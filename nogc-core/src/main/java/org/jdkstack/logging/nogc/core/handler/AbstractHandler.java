package org.jdkstack.logging.nogc.core.handler;

import java.nio.CharBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import org.jdkstack.logging.nogc.api.buffer.ByteWriter;
import org.jdkstack.logging.nogc.api.codec.CodecEncoder;
import org.jdkstack.logging.nogc.api.config.ContextConfiguration;
import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.api.config.RecorderConfig;
import org.jdkstack.logging.nogc.api.context.LogComponentContext;
import org.jdkstack.logging.nogc.api.handler.Handler;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.core.datetime.DateTimeDecoder;
import org.jdkstack.logging.nogc.core.datetime.DateTimeEncoder;
import org.jdkstack.logging.nogc.core.formatter.LogFormatterV2;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThread;
import org.jdkstack.logging.nogc.core.thread.LogProduceThread;
import org.jdkstack.logging.nogc.core.thread.utils.ThreadLocalTool;

/**
 * This is a method description.
 *
 * <p>.
 *
 * @author admin
 */
public abstract class AbstractHandler implements Handler {

  /** . */
  protected final LogComponentContext context;

  public AbstractHandler(final LogComponentContext context) {
    this.context = context;
  }

  @Override
  public void consume(final Record lr) throws Exception {
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    final CharBuffer charBuf = logConsumeThread.getCharBuf();
    final CodecEncoder<CharBuffer> textCodecEncoder = logConsumeThread.getTextEncoder();
    final HandlerConfig value = this.context.getHandlerConfig(lr.getName());
    final StringBuilder logMessage = this.context.formatter(value.getFormatter(), lr);
    charBuf.clear();
    final int position = charBuf.position();
    logMessage.getChars(0, logMessage.length(), charBuf.array(), position);
    charBuf.position(position + logMessage.length());
    charBuf.flip();
    this.rules(lr);
    final ByteWriter destination = logConsumeThread.getDestination();
    textCodecEncoder.encode(charBuf, destination);
    final int batchSize = value.getBatchSize();
    final AtomicInteger lines = destination.getLines();
    final int index = lines.get();
    if (index % batchSize == 0) {
      this.flush();
    }
  }

  @Override
  public void produce(StackTraceElement stackTraceElement, final String logLevel, final String dateTime, final String message, final String name, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Object arg9, final Throwable thrown, final Record lr) {
    final ContextConfiguration contextConfiguration = this.context.getContextConfiguration();
    lr.setLevelName(logLevel);
    lr.setLevelValue(this.context.findLevel(logLevel).intValue());
    long current = 0L;
    final StringBuilder dt = lr.getDateTime();
    if (dateTime != null) {
      current = DateTimeDecoder.decoder(dt.append(dateTime), contextConfiguration.getTimeZone());
    } else {
      current = System.currentTimeMillis();
      DateTimeEncoder.encoder(dt, current, contextConfiguration.getTimeZone());
    }
    final long year = DateTimeEncoder.year(current, contextConfiguration.getTimeZone());
    lr.setYear(year);
    final long month = DateTimeEncoder.month(current, contextConfiguration.getTimeZone());
    lr.setMonth(month);
    final long day = DateTimeEncoder.day(current, contextConfiguration.getTimeZone());
    lr.setDay(day);
    final long hours = DateTimeEncoder.hours(current, contextConfiguration.getTimeZone());
    lr.setHours(hours);
    final long minutes = DateTimeEncoder.minutes(current, contextConfiguration.getTimeZone());
    lr.setMinutes(minutes);
    final long seconds = DateTimeEncoder.seconds(current, contextConfiguration.getTimeZone());
    lr.setSeconds(seconds);
    lr.setParams(arg1, 0);
    lr.setParams(arg2, 1);
    lr.setParams(arg3, 2);
    lr.setParams(arg4, 3);
    lr.setParams(arg5, 4);
    lr.setParams(arg6, 5);
    lr.setParams(arg7, 6);
    lr.setParams(arg8, 7);
    lr.setParams(arg9, 8);
    LogFormatterV2.format(lr, message);
    lr.setName(name);
    lr.setThrown(thrown);
    if (stackTraceElement != null) {
      lr.setMethodName(stackTraceElement.getMethodName());
      lr.setClassName(stackTraceElement.getClassName());
      lr.setLineNumber(stackTraceElement.getLineNumber());
      lr.setFileName(stackTraceElement.getFileName());
    }
    RecorderConfig recorderConfig = context.getRecorderConfig(name);
    lr.setEventTypeName(recorderConfig.getEventTypeName());
    lr.setEventTypeValue(recorderConfig.getEventTypeValue());
    lr.setLogTypeName(recorderConfig.getLogTypeName());
    lr.setLogTypeValue(recorderConfig.getLogTypeValue());
    lr.setHostName(contextConfiguration.getHostName());
    lr.setApplicationSoftwareName(contextConfiguration.getApplicationSoftwareName());
    lr.setProcessId(contextConfiguration.getPid());
    lr.setTimeZone(contextConfiguration.getTimeZone());
    final LogProduceThread logProduceThread = ThreadLocalTool.getLogProduceThread();
    lr.setProducerThreadName(logProduceThread.getThreadName());
    lr.setProducerThreadValue(Thread.currentThread().getId());
  }

  /**
   * .
   *
   * <p>.
   *
   * @author admin
   */
  public void flush() throws Exception {
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    final ByteWriter destination = logConsumeThread.getDestination();
    destination.flush();
  }

  /**
   * .
   *
   * <p>.
   *
   * @param lr lr.
   * @author admin
   */
  public abstract void rules(final Record lr) throws Exception;
}
