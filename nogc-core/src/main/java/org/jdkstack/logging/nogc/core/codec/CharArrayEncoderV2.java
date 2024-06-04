package org.jdkstack.logging.nogc.core.codec;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import org.jdkstack.logging.nogc.api.buffer.ByteWriter;
import org.jdkstack.logging.nogc.api.codec.CodecEncoder;
import org.jdkstack.logging.nogc.core.Constants;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public class CharArrayEncoderV2 implements CodecEncoder<CharBuffer> {

  /** . */
  private final Charset charset;
  /** . */
  private final CharsetEncoder charsetEncoder;
  /** . */
  private final CharBuffer charBuffer;
  /** . */
  private final ByteBuffer byteBuffer;

  public CharArrayEncoderV2(final Charset charset) {
    this(charset, Constants.SOURCE, Constants.DESTINATION);
  }

  public CharArrayEncoderV2(final Charset charset, final int charBufferSize, final int byteBufferSize) {
    this.charset = charset;
    this.charsetEncoder = this.charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    this.charBuffer = CharBuffer.allocate(charBufferSize);
    this.byteBuffer = ByteBuffer.allocate(byteBufferSize);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param ce          .
   * @param charBuf     .
   * @param byteBuf     .
   * @param text        .
   * @param destination .
   * @author admin
   */
  public void encodeText(final CharsetEncoder ce, final CharBuffer charBuf, final ByteBuffer byteBuf, final CharBuffer text, final ByteWriter destination) throws Exception {
    ce.reset();
    charBuf.clear();
    charBuf.put(text.array(), text.arrayOffset(), text.remaining());
    charBuf.flip();
    ce.encode(charBuf, byteBuf, true);
    ce.flush(byteBuf);
    if (!byteBuf.equals(destination.getByteBuffer())) {
      byteBuf.flip();
      if (0 != byteBuf.remaining()) {
        writeTo(byteBuf, destination);
      }
      byteBuf.clear();
    }
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param source      .
   * @param destination .
   * @author admin
   */
  public void writeTo(final ByteBuffer source, final ByteWriter destination) throws Exception {
    final ByteBuffer destBuff = destination.getByteBuffer();
    while (source.remaining() > destBuff.remaining()) {
      destination.flush(destBuff);
    }
    destination.getLines().incrementAndGet();
    destination.getSizes().addAndGet(source.limit());
    destination.getSingleSizes().set(source.limit());
    destBuff.put(source);
  }

  @Override
  public void encode(final CharBuffer source, final ByteWriter destination) throws Exception {
    this.encodeText(this.charsetEncoder, this.charBuffer, this.byteBuffer, source, destination);
  }
}
