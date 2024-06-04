package org.jdkstack.logging.nogc.core.factory;

import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.api.config.RecorderConfig;
import org.jdkstack.logging.nogc.api.context.LogComponentContextFactory;
import org.jdkstack.logging.nogc.api.factory.Factory;
import org.jdkstack.logging.nogc.api.factory.Log;
import org.jdkstack.logging.nogc.api.filter.Filter;
import org.jdkstack.logging.nogc.api.formatter.Formatter;
import org.jdkstack.logging.nogc.api.handler.Handler;
import org.jdkstack.logging.nogc.api.recorder.Recorder;
import org.jdkstack.logging.nogc.api.thread.monitor.Monitor;
import org.jdkstack.logging.nogc.core.context.EventLogComponentContextFactory;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public class LogFactory implements Factory {

  /** . */
  private static final LogComponentContextFactory FACTORY = new EventLogComponentContextFactory();

  private LogFactory() {
    //
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param name .
   * @return .
   * @author admin
   */
  public static Log getLog(final String name) {
    return new EventLog(name, FACTORY);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param clazz .
   * @return .
   * @author admin
   */
  public static Log getLog(final Class<?> clazz) {
    return new EventLog(clazz.getName(), FACTORY);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param name .
   * @return .
   * @author admin
   */
  public static Recorder getRecorder(final String name) {
    return FACTORY.getRecorder(name);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param clazz .
   * @return .
   * @author admin
   */
  public static Recorder getRecorder(final Class<?> clazz) {
    return FACTORY.getRecorder(clazz.getName());
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param recorderConfig .
   * @author admin
   */
  public static void addRecorder(final RecorderConfig recorderConfig) {
    FACTORY.addRecorder(recorderConfig);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param key   .
   * @param value .
   * @author admin
   */
  public static void addHandler(final String key, final Handler value) {
    FACTORY.addHandler(key, value);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param key    .
   * @param filter .
   * @author admin
   */
  public static void addFilter(final String key, final Filter filter) {
    FACTORY.addFilter(key, filter);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param key       .
   * @param formatter .
   * @author admin
   */
  public static void addFormatter(final String key, final Formatter formatter) {
    FACTORY.addFormatter(key, formatter);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param key               .
   * @param logRecorderConfig .
   * @author admin
   */
  public static void addLogRecorderConfig(final String key, final RecorderConfig logRecorderConfig) {
    FACTORY.addLogRecorderConfig(key, logRecorderConfig);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param key              .
   * @param logHandlerConfig .
   * @author admin
   */
  public static void addLogHandlerConfig(final String key, final HandlerConfig logHandlerConfig) {
    FACTORY.addLogHandlerConfig(key, logHandlerConfig);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param name  .
   * @param value .
   * @author admin
   */
  public static void addLevel(final String name, final int value) {
    FACTORY.addLevel(name, value);
  }

  public static void start() {
    FACTORY.start();
  }

  public static void shutdown() {
    FACTORY.shutdown();
  }

  public static Monitor threadMonitor() {
    return FACTORY.threadMonitor();
  }
}
