package org.jdkstack.logging.nogc.core.tool;

import org.jdkstack.logging.nogc.core.thread.LogProduceThread;
import org.jdkstack.logging.nogc.core.thread.utils.ThreadLocalTool;

/**
 * boxing.
 *
 * <p>Make boxing explicit(StringBuilder->Object).
 *
 * @author admin
 */
public class Boxing {

  private Boxing() {
    //
  }

  public static StringBuilder box(final float value) {
    return getStringBuilder().append(value);
  }

  public static StringBuilder box(final double value) {
    return getStringBuilder().append(value);
  }

  public static StringBuilder box(final short value) {
    return getStringBuilder().append(value);
  }

  public static StringBuilder box(final int value) {
    return getStringBuilder().append(value);
  }

  public static StringBuilder box(final char value) {
    return getStringBuilder().append(value);
  }

  public static StringBuilder box(final long value) {
    return getStringBuilder().append(value);
  }

  public static StringBuilder box(final byte value) {
    return getStringBuilder().append(value);
  }

  public static StringBuilder box(final boolean value) {
    return getStringBuilder().append(value);
  }

  public static StringBuilder getStringBuilder() {
    LogProduceThread logProduceThread = ThreadLocalTool.getLogProduceThread();
    return logProduceThread.poll();
  }
}
