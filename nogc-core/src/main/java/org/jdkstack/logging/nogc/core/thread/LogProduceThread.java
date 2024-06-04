package org.jdkstack.logging.nogc.core.thread;

import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.core.record.LogRecord;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public final class LogProduceThread extends Thread {

  /** . */
  private static final int CAPACITY = 64;
  /** . */
  private static final int MASK = CAPACITY - 1;
  /** . */
  private final String name;
  /** . */
  private final StringBuilder[] ringBuffer = new StringBuilder[CAPACITY];
  /** . */
  private int current;
  /** . */
  private final Record record = new LogRecord();
  /** . */
  private long execStart;

  public LogProduceThread(ThreadGroup currentThreadGroup, final Runnable targetParam, final String nameParam) {
    super(currentThreadGroup, targetParam, nameParam);
    for (int i = 0; i < ringBuffer.length; i++) {
      ringBuffer[i] = new StringBuilder(21);
    }
    this.name = nameParam;
  }

  public LogProduceThread(final Runnable targetParam, final String nameParam) {
    super(targetParam, nameParam);
    for (int i = 0; i < ringBuffer.length; i++) {
      ringBuffer[i] = new StringBuilder(21);
    }
    this.name = nameParam;
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

  public StringBuilder poll() {
    final StringBuilder result = ringBuffer[MASK & current++];
    result.setLength(0);
    return result;
  }

  public Record getRecord() {
    return record;
  }

  public String getThreadName() {
    return this.name;
  }
}
