package org.jdkstack.logging.nogc.core.config;

import java.util.HashMap;
import java.util.Map;
import org.jdkstack.logging.nogc.api.config.Configuration;
import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.api.config.RecorderConfig;
import org.jdkstack.logging.nogc.api.filter.Filter;
import org.jdkstack.logging.nogc.api.formatter.Formatter;
import org.jdkstack.logging.nogc.api.handler.Handler;
import org.jdkstack.logging.nogc.api.level.Level;
import org.jdkstack.logging.nogc.api.policy.TriggeringPolicy;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.api.recorder.Recorder;
import org.jdkstack.logging.nogc.core.Constants;
import org.jdkstack.logging.nogc.core.level.LogLevel;

/**
 * Log metadata components configuration,include Handler,Recorder,Filter,Formatter,Level .
 *
 * <p>HandlerConfig,RecorderConfig,FilterConfig,FormatterConfig,LevelConfig.
 *
 * @author admin
 */
public class LogComponentConfiguration implements Configuration {

  /** . */
  private final Map<String, HandlerConfig> logHandlerConfigs = new HashMap<>(16);

  /** . */
  private final Map<String, RecorderConfig> logRecorderConfigs = new HashMap<>(1024);

  /** . */
  private final Map<String, Recorder> recorders = new HashMap<>(1000);

  /** . */
  private final Map<String, Filter> filters = new HashMap<>(32);

  /** . */
  private final Map<String, Formatter> formatters = new HashMap<>(32);

  /** . */
  private final Map<String, Handler> handlers = new HashMap<>(32);

  /** . */
  private final Map<String, Level> levels = new HashMap<>(32);

  /** . */
  private final Map<String, TriggeringPolicy> policys = new HashMap<>(32);

  @Override
  public Recorder getRecorder(final String name) {
    return this.recorders.get(name);
  }

  @Override
  public void addRecorder(final String name, final Recorder recorder) {
    this.recorders.put(name, recorder);
  }

  @Override
  public Handler getHandler(final String name) {
    Handler handler = this.handlers.get(name);
    if (handler == null) {
      handler = this.handlers.get(Constants.DEFAULT);
    }
    return handler;
  }

  @Override
  public void addHandler(final String key, final Handler value) {
    this.handlers.put(key, value);
  }

  @Override
  public void addFilter(final String key, final Filter filter) {
    this.filters.put(key, filter);
  }

  @Override
  public void addFormatter(final String key, final Formatter formatter) {
    this.formatters.put(key, formatter);
  }

  @Override
  public void addLogRecorderConfig(final String key, final RecorderConfig logRecorderConfig) {
    this.logRecorderConfigs.put(key, logRecorderConfig);
  }

  @Override
  public RecorderConfig getRecorderConfig(final String key) {
    RecorderConfig value = this.logRecorderConfigs.get(key);
    if (value == null) {
      value = this.logRecorderConfigs.get(Constants.DEFAULT);
    }
    return value;
  }

  @Override
  public void addLogHandlerConfig(final String key, final HandlerConfig logHandlerConfig) {
    this.logHandlerConfigs.put(key, logHandlerConfig);
  }

  @Override
  public HandlerConfig getLogHandlerConfig(final String key) {
    HandlerConfig value = this.logHandlerConfigs.get(key);
    if (value == null) {
      value = this.logHandlerConfigs.get(Constants.DEFAULT);
    }
    return value;
  }

  @Override
  public void addLevel(final String name, final int value) {
    final Level level = new LogLevel(name, value);
    this.levels.put(name, level);
  }

  @Override
  public Level findLevel(final String name) {
    Level level = this.levels.get(name);
    if (null == level) {
      level = new LogLevel(name, Constants.LEVEL_VALUE);
      this.levels.putIfAbsent(name, level);
    }
    return level;
  }

  @Override
  public StringBuilder formatter(final String formatterName, final Record logRecord) {
    Formatter formatter = this.formatters.get(formatterName);
    if (formatter == null) {
      formatter = this.formatters.get(Constants.DEFAULT);
    }
    return formatter.format(logRecord);
  }

  @Override
  public boolean filter(final String filterName, final Record logRecord) {
    Filter filter = this.filters.get(filterName);
    if (filter == null) {
      filter = this.filters.get(Constants.DEFAULT);
    }
    return filter.doFilter(logRecord);
  }

  @Override
  public void addPolicy(final String name, final TriggeringPolicy value) {
    this.policys.put(name, value);
  }

  @Override
  public TriggeringPolicy findPolicy(final String name) {
    return policys.get(name);
  }
}
