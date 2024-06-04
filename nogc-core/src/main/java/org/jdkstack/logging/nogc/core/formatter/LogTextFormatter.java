package org.jdkstack.logging.nogc.core.formatter;

import org.jdkstack.logging.nogc.api.context.LogComponentContext;
import org.jdkstack.logging.nogc.api.formatter.Formatter;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThread;
import org.jdkstack.logging.nogc.core.thread.utils.ThreadLocalTool;

/**
 * Text.
 *
 * <p>.
 *
 * @author admin
 */
public class LogTextFormatter implements Formatter {

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @author admin
   */
  public LogTextFormatter() {
    //
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @author admin
   */
  public LogTextFormatter(final LogComponentContext context) {
    //
  }

  @Override
  public StringBuilder format(final Record logRecord) {
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    final StringBuilder text = logConsumeThread.getText();
    text.setLength(0);
    this.handle(logRecord);
    final String lineSeparator = System.lineSeparator();
    text.append(lineSeparator);
    return text;
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logRecord .
   * @author admin
   */
  public void handle(final Record logRecord) {
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    final StringBuilder text = logConsumeThread.getText();
    final StringBuilder dateTime = logRecord.getDateTime();
    text.append(dateTime);
    text.append(' ');
    text.append(logRecord.getLevelName());
    text.append(' ');
    text.append(logRecord.getLevelValue());
    text.append(' ');
    text.append(logRecord.getProducerThreadName());
    text.append(' ');
    text.append(logRecord.getProducerThreadValue());
    text.append(' ');
    text.append(logConsumeThread.getThreadName());
    text.append(' ');
    text.append(Thread.currentThread().getId());
    text.append(' ');
    text.append(logRecord.getClassName());
    text.append(' ');
    text.append(logRecord.getMethodName());
    text.append(' ');
    text.append(logRecord.getLineNumber());
    text.append(' ');
    text.append(logRecord.getFileName());
    text.append(' ');
    text.append(logRecord.getName());
    text.append(' ');
    final StringBuilder format = logRecord.getMessageText();
    text.append(format);
    final Throwable thrown = logRecord.getThrowable();
    if (null != thrown) {
      text.append(' ');
      text.append('[');
      text.append(thrown.getClass().getName());
      text.append(':');
      text.append(thrown.getMessage());
      text.append(']');
    }
  }
}
