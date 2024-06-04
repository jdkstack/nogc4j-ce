package org.jdkstack.logging.nogc.api.codec;

import org.jdkstack.logging.nogc.api.buffer.ByteWriter;

/**
 * Characters encoder and Characters decoder.
 *
 * <p> Encode and Decode char[] or CharBuffer.
 *
 * @param <T> .
 * @author admin
 */
public interface CodecEncoder<T> {

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param source      .
   * @param destination .
   * @throws Exception .
   * @author admin
   */
  void encode(T source, ByteWriter destination) throws Exception;
}
