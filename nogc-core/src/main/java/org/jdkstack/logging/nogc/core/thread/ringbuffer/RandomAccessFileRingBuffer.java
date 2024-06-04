package org.jdkstack.logging.nogc.core.thread.ringbuffer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicInteger;
import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.api.thread.ringbuffer.RingBuffer;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public class RandomAccessFileRingBuffer implements RingBuffer<RandomAccessFile> {

  /** . */
  private final RandomAccessFile[] rb;
  /** . */
  private final FileChannel[] rb2;
  /** . */
  private final AtomicInteger[] rb3;
  /** . */
  private final int mask;
  /** . */
  private int current;
  /** . */
  private HandlerConfig rc;

  public RandomAccessFileRingBuffer(final RingBuffer<File> buffer, final HandlerConfig rc) {
    this.rc = rc;
    final int size = Power2.power2(rc.getCapacity());
    this.mask = size - 1;
    this.rb = new RandomAccessFile[size];
    this.rb2 = new FileChannel[size];
    this.rb3 = new AtomicInteger[size];
    for (int i = 0; i < size; i++) {
      RandomAccessFile file = null;
      try {
        file = new RandomAccessFile(buffer.poll(), rc.getMode());
      } catch (FileNotFoundException ignore) {
        //
        ignore.printStackTrace();
      }
      this.rb[i] = file;
      final FileChannel channel = file.getChannel();
      try {
        if (rc.isAppend()) {
          channel.truncate(file.length());
          file.seek(file.length());
        } else {
          channel.truncate(0);
          file.seek(0);
        }
      } catch (IOException ignore) {
        //
        ignore.printStackTrace();
      }
      this.rb2[i] = channel;
      this.rb3[i] = new AtomicInteger(0);
    }
  }

  @Override
  public RandomAccessFile poll() {
    final int index = this.current++;
    final RandomAccessFile file = this.rb[this.mask & index];
    final FileChannel channel = this.rb2[this.mask & index];
    final AtomicInteger atomicInteger = this.rb3[this.mask & index];
    try {
      int count = atomicInteger.getAndIncrement();
      if (rc.isAppend() && count < 10) {
        channel.truncate(file.length());
        file.seek(file.length());
      } else {
        channel.truncate(0);
        file.seek(0);
        atomicInteger.set(0);
      }
    } catch (IOException ignore) {
      //
      ignore.printStackTrace();
    }
    return file;
  }
}
