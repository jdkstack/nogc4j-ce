package org.jdkstack.logging.nogc.core.buffer;

import java.io.RandomAccessFile;

/**
 * Write bytes to Destination(For example, a disk),use the RandomAccess File API.
 *
 * <p>.
 *
 * @author admin
 */
public class ByteArrayWriter extends AbstractByteArrayWriter {

  /** Write data to the disk using the RandomAccess File API. */
  public RandomAccessFile randomAccessFile;

  @Override
  public void writeToDestination(final byte[] bytes, final int offset, final int length) throws Exception {
    this.randomAccessFile.write(bytes, offset, length);
  }

  @Override
  public void setDestination(final Object obj) {
    this.getSizes().set(0);
    this.getLines().set(0);
    this.randomAccessFile = (RandomAccessFile) obj;
  }
}
