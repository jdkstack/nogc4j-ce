package org.jdkstack.logging.nogc.core.thread;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import org.jdkstack.logging.nogc.api.buffer.ByteWriter;
import org.jdkstack.logging.nogc.api.codec.CodecEncoder;
import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.api.thread.ringbuffer.RingBuffer;
import org.jdkstack.logging.nogc.core.Constants;
import org.jdkstack.logging.nogc.core.buffer.ByteArrayWriter;
import org.jdkstack.logging.nogc.core.buffer.MmapByteArrayWriter;
import org.jdkstack.logging.nogc.core.codec.CharArrayEncoderV2;
import org.jdkstack.logging.nogc.core.thread.ringbuffer.FileRingBuffer;
import org.jdkstack.logging.nogc.core.thread.ringbuffer.RandomAccessFileRingBuffer;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public final class LogConsumeThread extends Thread {

  /** . */
  private final String name;
  /** . */
  private HandlerConfig rc;
  /** . */
  private File dir;
  /** . */
  private RingBuffer<File> fileBuffer;
  /** . */
  private RingBuffer<RandomAccessFile> randomAccessFileBuffer;
  /** . */
  private RandomAccessFile randomAccessFile;
  /** . */
  private MappedByteBuffer mappedBuffer;
  /** . */
  private FileChannel channel;
  /** . */
  private long execStart;
  /** . */
  private final ByteWriter destination = new ByteArrayWriter();
  /** . */
  private final ByteWriter mmapByteArrayWriter = new MmapByteArrayWriter();
  /** . */
  private final CharBuffer charBuf = CharBuffer.allocate(Constants.SOURCE);
  /** . */
  private final StringBuilder text = new StringBuilder(Constants.SOURCEN8);
  /** . */
  private final StringBuilder json = new StringBuilder(Constants.SOURCEN8);
  /** . */
  private final StringBuilder patternText = new StringBuilder(Constants.SOURCEN8);
  /** . */
  private final CodecEncoder<CharBuffer> textCodecEncoder = new CharArrayEncoderV2(Charset.defaultCharset());

  public LogConsumeThread(ThreadGroup currentThreadGroup, final Runnable targetParam, final String nameParam) {
    super(currentThreadGroup, targetParam, nameParam);
    this.name = nameParam;
  }

  public LogConsumeThread(final Runnable targetParam, final String nameParam) {
    super(targetParam, nameParam);
    this.name = nameParam;
  }

  public StringBuilder getText() {
    return this.text;
  }

  public StringBuilder getJson() {
    return this.json;
  }

  public CharBuffer getCharBuf() {
    return this.charBuf;
  }

  public CodecEncoder<CharBuffer> getTextEncoder() {
    return this.textCodecEncoder;
  }

  public ByteWriter getMmapByteArrayWriter() {
    return this.mmapByteArrayWriter;
  }

  public ByteWriter getDestination() {
    return this.destination;
  }

  public MappedByteBuffer getMappedBuffer() {
    return this.mappedBuffer;
  }

  public void setMappedBuffer(final MappedByteBuffer mappedBuffer) {
    this.mappedBuffer = mappedBuffer;
  }

  public FileChannel getChannel() {
    return this.channel;
  }

  public void setChannel(final FileChannel channel) {
    this.channel = channel;
  }

  public HandlerConfig getRc() {
    return this.rc;
  }

  public void setRc(final HandlerConfig rc) {
    this.rc = rc;
    this.dir = new File(this.rc.getDirectory() + File.separator + this.rc.getPrefix());
    this.dir.mkdirs();
    this.dir = new File(this.rc.getDirectory() + File.separator + this.rc.getPrefix() + File.separator + Thread.currentThread().getName());
    this.dir.mkdirs();
    this.fileBuffer = new FileRingBuffer(this.dir, this.rc);
    this.randomAccessFileBuffer = new RandomAccessFileRingBuffer(this.fileBuffer, this.rc);
  }

  public File getDir() {
    return this.dir;
  }

  public RingBuffer<File> getFileBuffer() {
    return this.fileBuffer;
  }

  public RingBuffer<RandomAccessFile> getRandomAccessFileBuffer() {
    return this.randomAccessFileBuffer;
  }

  public RandomAccessFile getRandomAccessFile() {
    return this.randomAccessFile;
  }

  public void setRandomAccessFile(final RandomAccessFile randomAccessFile) {
    this.randomAccessFile = randomAccessFile;
  }

  /**
   * .
   *
   * @return .
   * @author admin
   */
  public long startTime() {
    return this.execStart;
  }

  /**
   * .
   *
   * @author admin
   */
  private void executeStart() {
    this.execStart = System.currentTimeMillis();
  }

  private void executeEnd() {
    this.execStart = 0;
  }

  /**
   * .
   *
   * <p>.
   *
   * @author admin
   */
  public void beginEmission() {
    this.executeStart();
  }

  /**
   * .
   *
   * <p>.
   *
   * @author admin
   */
  public void endEmission() {
    this.executeEnd();
  }

  public String getThreadName() {
    return this.name;
  }

  public StringBuilder getPatternText() {
    return this.patternText;
  }
}
