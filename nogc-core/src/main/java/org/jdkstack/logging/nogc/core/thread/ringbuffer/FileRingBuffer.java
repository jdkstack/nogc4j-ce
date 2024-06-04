package org.jdkstack.logging.nogc.core.thread.ringbuffer;

import java.io.File;
import java.io.IOException;
import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.api.thread.ringbuffer.RingBuffer;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public class FileRingBuffer implements RingBuffer<File> {

  /** . */
  private final File[] rb;
  /** . */
  private final int mask;
  /** . */
  private int current;

  public FileRingBuffer(final File dir, final HandlerConfig rc) {
    final int capacity = rc.getCapacity();
    final int size = Power2.power2(capacity);
    this.mask = size - 1;
    this.rb = new File[size];
    for (int i = 0; i < size; i++) {
      final File file = new File(dir, i + rc.getFileNameExt());
      try {
        file.createNewFile();
      } catch (IOException ignore) {
        //
        ignore.printStackTrace();
      }
      this.rb[i] = file;
    }
  }

  @Override
  public File poll() {
    final File result = this.rb[this.mask & this.current++];
    return result;
  }
}
