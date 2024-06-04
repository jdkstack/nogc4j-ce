package org.jdkstack.logging.nogc.core.buffer;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.jdkstack.logging.nogc.api.buffer.ByteWriter;
import org.jdkstack.logging.nogc.core.Constants;

/**
 * Write bytes to Destination(For example, a disk).
 *
 * <p>.
 *
 * @author admin
 */
public abstract class AbstractByteArrayWriter implements ByteWriter {

  /** . */
  private AtomicInteger sizes = new AtomicInteger(0);
  /** . */
  private AtomicInteger lines = new AtomicInteger(0);
  /** . */
  private AtomicInteger singleSizes = new AtomicInteger(0);
  /** . */
  private AtomicLong merge = new AtomicLong(-1L);
  /** Bytebuffer size eq 256KB,cache data. */
  public final ByteBuffer byteBuffer = ByteBuffer.allocate(Constants.N256 << Constants.N10);

  @Override
  public void flush() throws Exception {
    this.flush(this.byteBuffer);
  }

  @Override
  public void flush(final ByteBuffer buf) throws Exception {
    // Flips this buffer.
    buf.flip();
    try {
      // The number of elements between the current position and the limit.
      if (0 < buf.remaining()) {
        // Write data to the disk,Call business methods.
        this.writeToDestination(buf.array(), buf.arrayOffset() + buf.position(), buf.remaining());
      }
    } finally {
      // Clean up buf,This is a synchronous operation.
      buf.clear();
    }
  }

  @Override
  public ByteBuffer getByteBuffer() {
    return this.byteBuffer;
  }

  @Override
  public AtomicInteger getSizes() {
    return this.sizes;
  }

  @Override
  public AtomicInteger getLines() {
    return this.lines;
  }

  @Override
  public AtomicInteger getSingleSizes() {
    return this.singleSizes;
  }

  @Override
  public void setSingleSizes(final AtomicInteger singleSizes) {
    this.singleSizes = singleSizes;
  }

  @Override
  public AtomicLong getMerge() {
    return this.merge;
  }

  @Override
  public void setMerge(final AtomicLong merge) {
    this.merge = merge;
  }
}
