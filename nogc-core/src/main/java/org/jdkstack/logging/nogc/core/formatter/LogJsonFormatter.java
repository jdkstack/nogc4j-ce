package org.jdkstack.logging.nogc.core.formatter;

import org.jdkstack.logging.nogc.api.context.LogComponentContext;
import org.jdkstack.logging.nogc.api.formatter.Formatter;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThread;
import org.jdkstack.logging.nogc.core.thread.utils.ThreadLocalTool;

/**
 * Json.
 *
 * <p>.
 *
 * @author admin
 */
public class LogJsonFormatter implements Formatter {

  public LogJsonFormatter() {
    //
  }

  public LogJsonFormatter(final LogComponentContext context) {
    //
  }

  @Override
  public StringBuilder format(final Record logRecord) {
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    final StringBuilder json = logConsumeThread.getJson();
    json.setLength(0);
    this.handle(logRecord);
    return json;
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
    final StringBuilder json = logConsumeThread.getJson();
    json.append("{\"dateTime\":\"");
    json.append(logRecord.getDateTime());
    json.append("\",");
    json.append("\"levelName\":\"");
    json.append(logRecord.getLevelName());
    json.append("\",");
    json.append("\"levelValue\":");
    json.append(logRecord.getLevelValue());
    json.append(',');
    json.append("\"producerThreadName\":\"");
    json.append(logRecord.getProducerThreadName());
    json.append("\",");
    json.append("\"producerThreadValue\":\"");
    json.append(logRecord.getProducerThreadValue());
    json.append("\",");
    json.append("\"consumerThreadName\":\"");
    json.append(logConsumeThread.getThreadName());
    json.append("\",");
    json.append("\"consumerThreadValue\":\"");
    json.append(Thread.currentThread().getId());
    json.append("\",");
    json.append("\"name\":\"");
    json.append(logRecord.getName());
    json.append("\",");
    json.append("\"className\":\"");
    json.append(logRecord.getClassName());
    json.append("\",");
    json.append("\"methodName\":\"");
    json.append(logRecord.getMethodName());
    json.append("\",");
    json.append("\"lineNumber\":\"");
    json.append(logRecord.getLineNumber());
    json.append("\",");
    json.append("\"fileName\":\"");
    json.append(logRecord.getFileName());
    json.append("\",");
    json.append("\"message\":\"");
    json.append(logRecord.getMessageText());
    json.append('"');
    final Throwable thrown = logRecord.getThrowable();
    if (null != thrown) {
      json.append(",\"stacktrace\":[\"");
      json.append(thrown.getClass().getName());
      json.append(':');
      json.append(thrown.getMessage());
      json.append("\"]");
    }
    json.append('}').append(System.lineSeparator());
  }
}
