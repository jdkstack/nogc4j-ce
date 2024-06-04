package org.jdkstack.logging.nogc.core.buffer;

import java.nio.MappedByteBuffer;

/**
 * Write bytes to Destination(For example, a disk),use the MappedByteBuffer File API.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public class MmapByteArrayWriter extends ByteArrayWriter {

  /** Write data to the disk using the MappedByteBuffer File API. */
  private MappedByteBuffer mappedBuffer;

  public MmapByteArrayWriter() {
    //
  }

  @Override
  public void writeToDestination(final byte[] bytes, final int offset, final int length) throws Exception {
    this.mappedBuffer.put(bytes, offset, length);
  }

  @Override
  public void setDestination(Object obj) {
    this.getSizes().set(0);
    this.mappedBuffer = (MappedByteBuffer) obj;
  }
}
