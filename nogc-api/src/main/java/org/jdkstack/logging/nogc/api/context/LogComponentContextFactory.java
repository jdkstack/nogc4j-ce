package org.jdkstack.logging.nogc.api.context;

import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.api.config.RecorderConfig;
import org.jdkstack.logging.nogc.api.filter.Filter;
import org.jdkstack.logging.nogc.api.formatter.Formatter;
import org.jdkstack.logging.nogc.api.handler.Handler;
import org.jdkstack.logging.nogc.api.policy.TriggeringPolicy;
import org.jdkstack.logging.nogc.api.recorder.Recorder;
import org.jdkstack.logging.nogc.api.thread.monitor.Monitor;

/**
 * This is a method description.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public interface LogComponentContextFactory {

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
   * @param recorderConfig .
   * @author admin
   */
  void addRecorder(RecorderConfig recorderConfig);

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

  void addPolicy(String name, TriggeringPolicy value);

  TriggeringPolicy findPolicy(String name);

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
}
