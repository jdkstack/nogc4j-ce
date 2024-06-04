package org.jdkstack.logging.nogc.api.context;

import org.jdkstack.logging.nogc.api.config.ContextConfiguration;
import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.api.config.RecorderConfig;
import org.jdkstack.logging.nogc.api.filter.Filter;
import org.jdkstack.logging.nogc.api.formatter.Formatter;
import org.jdkstack.logging.nogc.api.handler.Handler;
import org.jdkstack.logging.nogc.api.level.Level;
import org.jdkstack.logging.nogc.api.policy.TriggeringPolicy;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.api.recorder.Recorder;
import org.jdkstack.logging.nogc.api.thread.monitor.Monitor;

/**
 * This is a method description.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public interface LogComponentContext {

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param name .
   * @return Recorder .
   * @author admin
   */
  Recorder getRecorder(String name);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param name .
   * @return Recorder .
   * @author admin
   */
  void addRecorder(String name, Recorder recorder);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param name .
   * @return Recorder .
   * @author admin
   */
  Handler getHandler(String name);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param key   .
   * @param value .
   * @author admin
   */
  void addHandler(String key, Handler value);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param key    .
   * @param filter .
   * @author admin
   */
  void addFilter(String key, Filter filter);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param key       .
   * @param formatter .
   * @author admin
   */
  void addFormatter(String key, Formatter formatter);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param key               .
   * @param logRecorderConfig .
   * @author admin
   */
  void addLogRecorderConfig(String key, RecorderConfig logRecorderConfig);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param key .
   * @return RecorderConfig .
   * @author admin
   */
  RecorderConfig getRecorderConfig(String key);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param key              .
   * @param logHandlerConfig .
   * @author admin
   */
  void addLogHandlerConfig(String key, HandlerConfig logHandlerConfig);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param key .
   * @return HandlerConfig .
   * @author admin
   */
  HandlerConfig getHandlerConfig(String key);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param name  .
   * @param value .
   * @author admin
   */
  void addLevel(String name, int value);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param minLevelName .
   * @param logLevelName .
   * @param maxLevelName .
   * @author admin
   */
  boolean doFilter(String logLevelName, int maxLevelName, int minLevelName);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param name .
   * @return Recorder .
   * @author admin
   */
  Level findLevel(String name);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param formatterName .
   * @param logRecord     .
   * @return StringBuilder .
   * @author admin
   */
  StringBuilder formatter(String formatterName, Record logRecord);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param filterName .
   * @param logRecord  .
   * @return boolean .
   * @author admin
   */
  boolean filter(String filterName, Record logRecord);

  void addPolicy(String name, TriggeringPolicy value);

  TriggeringPolicy findPolicy(String name);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param event .
   * @author admin
   */
  void consume(Record event);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param stackTraceElement .
   * @param logLevel          .
   * @param message           .
   * @param arg1              .
   * @param arg2              .
   * @param arg3              .
   * @param arg4              .
   * @param arg5              .
   * @param arg6              .
   * @param arg7              .
   * @param arg8              .
   * @param arg9              .
   * @param thrown            .
   * @param lr                .
   * @author admin
   */
  void produce(StackTraceElement stackTraceElement, String logLevel, String dateTime, String message, String name, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Throwable thrown, Record lr);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param arg4     .
   * @param arg5     .
   * @param arg6     .
   * @param arg7     .
   * @param arg8     .
   * @param arg9     .
   * @param thrown   .
   * @param lr       .
   * @author admin
   */

  void asynchronous(int index, String logLevel, String dateTime, String message, String name, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Throwable thrown);

  void synchronous(int index, String logLevel, String dateTime, String message, String name, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Throwable thrown);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @author admin
   */
  void start();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @author admin
   */
  void shutdown();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return Monitor .
   * @author admin
   */
  Monitor threadMonitor();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return ContextConfiguration .
   * @author admin
   */
  ContextConfiguration getContextConfiguration();
}
