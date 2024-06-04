package org.jdkstack.logging.nogc.api.buffer;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Write bytes to the Destination(For example, a disk).
 *
 * <p>.
 *
 * @author admin
 */
public interface ByteWriter {

  /**
   * Return current byteBuffer(256kb).
   *
   * <p>.
   *
   * @return ByteBuffer .
   * @author admin
   */
  ByteBuffer getByteBuffer();

  /**
   * Refresh bytes to Destination(For example, a disk).
   *
   * <p>Refresh param buf.
   *
   * @param buf .
   * @throws Exception .
   * @author admin
   */
  void flush(ByteBuffer buf) throws Exception;

  /**
   * Refresh bytes to Destination(For example, a disk).
   *
   * <p>Refresh current byteBuffer(256kb).
   *
   * @throws Exception .
   * @author admin
   */
  void flush() throws Exception;

  /**
   * Write bytes to the Destination(For example, a disk).
   *
   * <p>Final business implementation.
   *
   * @param bytes  .
   * @param offset .
   * @param length .
   * @throws Exception .
   * @author admin
   */
  void writeToDestination(final byte[] bytes, final int offset, final int length) throws Exception;

  /**
   * Set a destination.
   *
   * <p>And clear the count (size and line).
   *
   * @param obj obj .
   * @author admin
   */
  void setDestination(Object obj);

  /**
   * The count size.
   *
   * <p>Another description after blank line.
   *
   * @author admin
   */
  AtomicInteger getSizes();

  /**
   * The count line.
   *
   * <p>Another description after blank line.
   *
   * @author admin
   */
  AtomicInteger getLines();

  AtomicInteger getSingleSizes();

  void setSingleSizes(AtomicInteger singleSizes);

  AtomicLong getMerge();

  void setMerge(AtomicLong merge);
}
