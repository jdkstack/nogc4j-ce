package org.jdkstack.logging.nogc.core.tool;

/**
 * unboxing.
 *
 * <p>Make unboxing explicit (Object->StringBuilder).
 *
 * @author admin
 */
public class Unboxing {

  private Unboxing() {
    //
  }

  /**
   * .
   *
   * <p>Another description after blank line.
   *
   * @param sb  .
   * @param arg .
   * @author admin
   */
  public static void unbox(final StringBuilder sb, final Object arg) {
    if (arg == null) {
      //
    } else if (arg instanceof Integer) {
      sb.append(((Integer) arg).intValue());
    } else if (arg instanceof Short) {
      sb.append(((Short) arg).shortValue());
    } else if (arg instanceof String) {
      sb.append((String) arg);
    } else if (arg instanceof Long) {
      sb.append(((Long) arg).longValue());
    } else if (arg instanceof Character) {
      sb.append(((Character) arg).charValue());
    } else if (arg instanceof Double) {
      sb.append(((Double) arg).doubleValue());
    } else if (arg instanceof Float) {
      sb.append(((Float) arg).floatValue());
    } else if (arg instanceof Boolean) {
      sb.append(((Boolean) arg).booleanValue());
    } else if (arg instanceof Byte) {
      sb.append(((Byte) arg).byteValue());
    } else {
      sb.append((StringBuilder) arg);
    }
  }
}
