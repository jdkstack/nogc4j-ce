package org.jdkstack.logging.nogc.api.config;

import org.jdkstack.logging.nogc.api.filter.Filter;
import org.jdkstack.logging.nogc.api.formatter.Formatter;
import org.jdkstack.logging.nogc.api.handler.Handler;
import org.jdkstack.logging.nogc.api.level.Level;
import org.jdkstack.logging.nogc.api.policy.TriggeringPolicy;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.api.recorder.Recorder;

/**
 * This is a method description.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public interface Configuration {

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
   * @param name     .
   * @param recorder .
   * @author admin
   */
  void addRecorder(String name, Recorder recorder);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param name .
   * @return Handler .
   * @author admin
   */
  Handler getHandler(String name);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param key .
   * @value value .
   * @author admin
   */
  void addHandler(String key, Handler value);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param key .
   * @value filter .
   * @author admin
   */
  void addFilter(String key, Filter filter);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param key .
   * @value formatter .
   * @author admin
   */
  void addFormatter(String key, Formatter formatter);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param key .
   * @value logRecorderConfig .
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
  HandlerConfig getLogHandlerConfig(String key);

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
   * @param name .
   * @return Level .
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
}
