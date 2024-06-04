package org.jdkstack.logging.nogc.core.context;

import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.api.config.RecorderConfig;
import org.jdkstack.logging.nogc.api.context.LogComponentContextFactory;
import org.jdkstack.logging.nogc.api.filter.Filter;
import org.jdkstack.logging.nogc.api.formatter.Formatter;
import org.jdkstack.logging.nogc.api.handler.Handler;
import org.jdkstack.logging.nogc.api.lifecycle.LifecycleState;
import org.jdkstack.logging.nogc.api.policy.TriggeringPolicy;
import org.jdkstack.logging.nogc.api.recorder.Recorder;
import org.jdkstack.logging.nogc.api.thread.monitor.Monitor;
import org.jdkstack.logging.nogc.core.Constants;
import org.jdkstack.logging.nogc.core.config.LogHandlerConfig;
import org.jdkstack.logging.nogc.core.config.LogRecorderConfig;
import org.jdkstack.logging.nogc.core.formatter.LogJsonFormatter;
import org.jdkstack.logging.nogc.core.formatter.LogTextFormatter;
import org.jdkstack.logging.nogc.core.handler.FileHandlerV2;
import org.jdkstack.logging.nogc.core.handler.MmapFileHandlerV2;
import org.jdkstack.logging.nogc.core.policy.LineBasedTriggeringPolicy;
import org.jdkstack.logging.nogc.core.policy.MmapSizeBasedTriggeringPolicy;
import org.jdkstack.logging.nogc.core.policy.SizeBasedTriggeringPolicy;
import org.jdkstack.logging.nogc.core.policy.TimeBasedTriggeringPolicy;
import org.jdkstack.logging.nogc.core.recorder.LogRecorder;

/**
 * .
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public class EventLogComponentContextFactory implements LogComponentContextFactory {

  /** . */
  private final EventLogComponentContext context = new EventLogComponentContext();

  public EventLogComponentContextFactory() {
    this.context.setState(LifecycleState.STARTING);
    this.insideConfig();
    this.context.setState(LifecycleState.STARTED);
  }

  @Override
  public Recorder getRecorder(final String name) {
    Recorder recorder = this.context.getRecorder(name);
    if (null == recorder) {
      recorder = this.context.getRecorder(Constants.DEFAULT);
    }
    return recorder;
  }

  @Override
  public void addRecorder(final RecorderConfig recorderConfig) {
    final Recorder logRecorder = new LogRecorder(this.context, recorderConfig);
    this.context.addRecorder(recorderConfig.getName(), logRecorder);
  }

  @Override
  public void addHandler(final String key, final Handler value) {
    this.context.addHandler(key, value);
  }

  @Override
  public void addFilter(final String key, final Filter filter) {
    this.context.addFilter(key, filter);
  }

  @Override
  public void addFormatter(final String key, final Formatter formatter) {
    this.context.addFormatter(key, formatter);
  }

  @Override
  public void addPolicy(final String name, final TriggeringPolicy value) {
    this.context.addPolicy(name, value);
  }

  @Override
  public TriggeringPolicy findPolicy(final String name) {
    return context.findPolicy(name);
  }

  @Override
  public void addLogRecorderConfig(final String key, final RecorderConfig logRecorderConfig) {
    this.context.addLogRecorderConfig(key, logRecorderConfig);
  }

  @Override
  public void addLogHandlerConfig(final String key, final HandlerConfig logHandlerConfig) {
    this.context.addLogHandlerConfig(key, logHandlerConfig);
  }

  @Override
  public void addLevel(final String name, final int value) {
    this.context.addLevel(name, value);
  }

  @Override
  public void start() {
    this.context.start();
  }

  @Override
  public void shutdown() {
    this.context.shutdown();
  }

  @Override
  public Monitor threadMonitor() {
    return this.context.threadMonitor();
  }

  private void insideConfig() {
    this.addLevel(Constants.MIN, Constants.MIN_VALUE);
    this.addLevel(Constants.SEVERE, Constants.SEVERE_VALUE);
    this.addLevel(Constants.FATAL, Constants.FATAL_VALUE);
    this.addLevel(Constants.ERROR, Constants.ERROR_VALUE);
    this.addLevel(Constants.WARN, Constants.WARN_VALUE);
    this.addLevel(Constants.INFO, Constants.INFO_VALUE);
    this.addLevel(Constants.DEBUG, Constants.DEBUG_VALUE);
    this.addLevel(Constants.CONFIG, Constants.CONFIG_VALUE);
    this.addLevel(Constants.FINE, Constants.FINE_VALUE);
    this.addLevel(Constants.FINER, Constants.FINER_VALUE);
    this.addLevel(Constants.FINEST, Constants.FINEST_VALUE);
    this.addLevel(Constants.TRACE, Constants.TRACE_VALUE);
    this.addLevel(Constants.MAX, Constants.MAX_VALUE);
    final RecorderConfig recorderConfig = new LogRecorderConfig();
    this.addLogRecorderConfig(Constants.DEFAULT, recorderConfig);
    this.addRecorder(recorderConfig);
    final HandlerConfig handlerConfig = new LogHandlerConfig();
    this.addLogHandlerConfig(Constants.DEFAULT, handlerConfig);
    final Handler fileHandlerV2 = new FileHandlerV2(this.context);
    this.addHandler(Constants.DEFAULT, fileHandlerV2);
    final HandlerConfig mmapRecorderConfig = new LogHandlerConfig();
    mmapRecorderConfig.setName("mmap");
    mmapRecorderConfig.setPolicy("mmapSizeBasedTriggeringPolicy");
    this.addLogHandlerConfig("mmap", mmapRecorderConfig);
    final Handler mmap = new MmapFileHandlerV2(this.context);
    this.addHandler("mmap", mmap);
    final Formatter logJsonFormatter = new LogJsonFormatter(this.context);
    this.addFormatter("logJsonFormatter", logJsonFormatter);
    final Formatter logTextFormatter = new LogTextFormatter(this.context);
    this.addFormatter("logTextFormatter", logTextFormatter);
    TriggeringPolicy lineBasedTriggeringPolicy = new LineBasedTriggeringPolicy(this.context);
    this.addPolicy("lineBasedTriggeringPolicy", lineBasedTriggeringPolicy);
    TriggeringPolicy sizeBasedTriggeringPolicy = new SizeBasedTriggeringPolicy(this.context);
    this.addPolicy("sizeBasedTriggeringPolicy", sizeBasedTriggeringPolicy);
    TriggeringPolicy mmapSizeBasedTriggeringPolicy = new MmapSizeBasedTriggeringPolicy(this.context);
    this.addPolicy("mmapSizeBasedTriggeringPolicy", mmapSizeBasedTriggeringPolicy);
    TimeBasedTriggeringPolicy timeBasedTriggeringPolicy = new TimeBasedTriggeringPolicy(this.context);
    this.addPolicy("timeBasedTriggeringPolicy", timeBasedTriggeringPolicy);
  }
}
