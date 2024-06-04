package org.jdkstack.logging.nogc.core.thread.ringbuffer;

/**
 * .
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public final class Power2 {

  private Power2() {
    //
  }

  /**
   * .
   *
   * <p>.
   *
   * @param value .
   * @return .
   * @author admin
   */
  public static int power2(final int value) {
    // value=4,newValue=3
    final int newValue = value - 1;
    // 3 has 0000 0000 0000 0000 0000 0000 0000 0011
    // 0(30)
    final int count1 = Integer.numberOfLeadingZeros(newValue);
    // 1(2)
    final int count2 = 32 - count1;
    // 2(s)
    return 1 << count2;
  }
}
