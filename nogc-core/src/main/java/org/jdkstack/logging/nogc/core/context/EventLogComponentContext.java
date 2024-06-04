package org.jdkstack.logging.nogc.core.context;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import java.util.HashMap;
import java.util.Map;
import org.jdkstack.logging.nogc.api.config.Configuration;
import org.jdkstack.logging.nogc.api.config.ContextConfiguration;
import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.api.config.RecorderConfig;
import org.jdkstack.logging.nogc.api.context.LogComponentContext;
import org.jdkstack.logging.nogc.api.filter.Filter;
import org.jdkstack.logging.nogc.api.formatter.Formatter;
import org.jdkstack.logging.nogc.api.handler.Handler;
import org.jdkstack.logging.nogc.api.level.Level;
import org.jdkstack.logging.nogc.api.lifecycle.LifecycleState;
import org.jdkstack.logging.nogc.api.policy.TriggeringPolicy;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.api.recorder.Recorder;
import org.jdkstack.logging.nogc.api.thread.monitor.Monitor;
import org.jdkstack.logging.nogc.core.config.LogComponentConfiguration;
import org.jdkstack.logging.nogc.core.config.LogComponentContextConfiguration;
import org.jdkstack.logging.nogc.core.lifecycle.LifecycleBase;
import org.jdkstack.logging.nogc.core.record.RecordEventFactory;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThread;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThreadFactory;
import org.jdkstack.logging.nogc.core.thread.LogProduceThread;
import org.jdkstack.logging.nogc.core.thread.monitor.ThreadMonitor;
import org.jdkstack.logging.nogc.core.thread.utils.ThreadLocalTool;

/**
 * .
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public class EventLogComponentContext extends LifecycleBase implements LogComponentContext {

  /** . */
  private final Configuration configuration = new LogComponentConfiguration();
  /** . */
  private final ContextConfiguration contextConfiguration = new LogComponentContextConfiguration();
  /** . */
  private final ThreadMonitor threadMonitor = new ThreadMonitor();
  /** <=3600. */
  private Map<Integer, StackTraceElement[]> stackTraces = new HashMap<>(4800);
  /** . */
  private Disruptor<Record> disruptor = null;

  public EventLogComponentContext() {
    this.setState(LifecycleState.INITIALIZING);
    start();
    this.setState(LifecycleState.INITIALIZED);
  }

  @Override
  public Recorder getRecorder(final String name) {
    return this.configuration.getRecorder(name);
  }

  @Override
  public void addRecorder(final String name, final Recorder recorder) {
    this.configuration.addRecorder(name, recorder);
  }

  @Override
  public Handler getHandler(final String name) {
    return this.configuration.getHandler(name);
  }

  @Override
  public void addHandler(final String key, final Handler value) {
    this.configuration.addHandler(key, value);
  }

  @Override
  public void addFilter(final String key, final Filter filter) {
    this.configuration.addFilter(key, filter);
  }

  @Override
  public void addFormatter(final String key, final Formatter formatter) {
    this.configuration.addFormatter(key, formatter);
  }

  @Override
  public void addLogRecorderConfig(final String key, final RecorderConfig logRecorderConfig) {
    this.configuration.addLogRecorderConfig(key, logRecorderConfig);
  }

  @Override
  public RecorderConfig getRecorderConfig(final String key) {
    return this.configuration.getRecorderConfig(key);
  }

  @Override
  public void addLogHandlerConfig(final String key, final HandlerConfig logHandlerConfig) {
    this.configuration.addLogHandlerConfig(key, logHandlerConfig);
  }

  @Override
  public HandlerConfig getHandlerConfig(final String key) {
    return this.configuration.getLogHandlerConfig(key);
  }

  @Override
  public void addLevel(final String name, final int value) {
    this.configuration.addLevel(name, value);
  }

  @Override
  public boolean doFilter(final String logLevelName, final int maxLevelName, final int minLevelName) {
    final Level logLevel = this.findLevel(logLevelName);
    final int value = logLevel.intValue();
    final boolean b2 = value <= maxLevelName;
    final boolean b1 = value >= minLevelName;
    return b2 && b1;
  }

  @Override
  public Level findLevel(final String name) {
    return this.configuration.findLevel(name);
  }

  @Override
  public StringBuilder formatter(final String formatterName, final Record logRecord) {
    return this.configuration.formatter(formatterName, logRecord);
  }

  @Override
  public boolean filter(final String filterName, final Record logRecord) {
    return this.configuration.filter(filterName, logRecord);
  }

  @Override
  public void addPolicy(final String name, final TriggeringPolicy value) {
    this.configuration.addPolicy(name, value);
  }

  @Override
  public TriggeringPolicy findPolicy(final String name) {
    return configuration.findPolicy(name);
  }

  @Override
  public void consume(final Record lr) {
    try {
      final RecorderConfig recorderConfig = this.getRecorderConfig(lr.getName());
      final String handlers = recorderConfig.getHandlers();
      final HandlerConfig handlerConfig = this.getHandlerConfig(handlers);
      final Handler handler = this.getHandler(handlerConfig.getName());
      handler.consume(lr);
    } catch (final Exception ignore) {
      // ignore.
      ignore.printStackTrace();
    } finally {
      LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
      if (threadMonitor.isNull(logConsumeThread.getId())) {
        threadMonitor.registerThread(logConsumeThread);
      }
    }
  }

  @Override
  public void produce(final StackTraceElement stackTraceElement, final String logLevel, final String dateTime, final String message, final String name, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Object arg9, final Throwable thrown, final Record lr) {
    try {
      final RecorderConfig recorderConfig = this.getRecorderConfig(name);
      final String handlers = recorderConfig.getHandlers();
      final HandlerConfig handlerConfig = this.getHandlerConfig(handlers);
      final Handler handler = this.getHandler(handlerConfig.getName());
      handler.produce(stackTraceElement, logLevel, dateTime, message, name, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, thrown, lr);
    } catch (final Exception ignore) {
      // ignore.
      ignore.printStackTrace();
    } finally {
      LogProduceThread logProduceThread = ThreadLocalTool.getLogProduceThread();
      if (threadMonitor.isNull(logProduceThread.getId())) {
        threadMonitor.registerThread(logProduceThread);
      }
    }
  }

  @Override
  public void asynchronous(final int index, final String logLevel, final String dateTime, final String message, final String name, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Object arg9, final Throwable thrown) {
    if (LifecycleState.STARTED == getState()) {
      final RecorderConfig recorderConfig = this.getRecorderConfig(name);
      final String handlers = recorderConfig.getHandlers();
      final HandlerConfig handlerConfig = this.getHandlerConfig(handlers);
      final RingBuffer<Record> ringBuffer = disruptor.getRingBuffer();
      final long sequence = ringBuffer.next();
      try {
        final Record record = ringBuffer.get(sequence);
        StackTraceElement stackTraceElement = null;
        if (index != 0) {
          StackTraceElement[] stackTraceElements = this.stackTraces.get(index);
          if (stackTraceElements == null) {
            final Throwable t = new Throwable();
            this.stackTraces.put(index, t.getStackTrace());
            stackTraceElements = this.stackTraces.get(index);
          }
          stackTraceElement = stackTraceElements[5];
        }
        this.produce(stackTraceElement, logLevel, dateTime, message, name, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, thrown, record);
      } finally {
        ringBuffer.publish(sequence);
      }
    } else {
      this.synchronous(index, logLevel, dateTime, message, name, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, thrown);
    }
  }

  @Override
  public void synchronous(final int index, final String logLevel, final String dateTime, final String message, final String name, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Object arg9, final Throwable thrown) {
    final LogProduceThread logProduceThread = ThreadLocalTool.getLogProduceThread();
    final Record record = logProduceThread.getRecord();
    final RecorderConfig recorderConfig = this.getRecorderConfig(name);
    final String handlers = recorderConfig.getHandlers();
    final HandlerConfig handlerConfig = this.getHandlerConfig(handlers);
    try {
      StackTraceElement stackTraceElement = null;
      if (index != 0) {
        StackTraceElement[] stackTraceElements = this.stackTraces.get(index);
        if (stackTraceElements == null) {
          final Throwable t = new Throwable();
          this.stackTraces.put(index, t.getStackTrace());
          stackTraceElements = this.stackTraces.get(index);
        }
        stackTraceElement = stackTraceElements[5];
      }
      this.produce(stackTraceElement, logLevel, dateTime, message, name, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, thrown, record);
      this.consume(record);
    } finally {
      record.clear();
    }
  }

  @Override
  public void start() {
    this.setState(LifecycleState.STARTING);
    final EventFactory<Record> eventFactory = new RecordEventFactory();
    final WaitStrategy waitStrategy = new BusySpinWaitStrategy();
    this.disruptor = new Disruptor<>(eventFactory, contextConfiguration.getRingBufferSize(), new LogConsumeThreadFactory("default-log-consume", null), ProducerType.MULTI, waitStrategy);
    final ExceptionHandler<Record> errorHandler = new ExceptionHandler<Record>() {
      @Override
      public void handleEventException(Throwable ignore, long sequence, Record event) {
        //
      }

      @Override
      public void handleOnStartException(Throwable ex) {
        //
      }

      @Override
      public void handleOnShutdownException(Throwable ex) {
        //
      }
    };
    this.disruptor.setDefaultExceptionHandler(errorHandler);
    final RingBufferLogWorkHandler[] workHandlers = new RingBufferLogWorkHandler[contextConfiguration.getConsumers()];
    for (int i = 0; i < workHandlers.length; i++) {
      workHandlers[i] = new RingBufferLogWorkHandler(this);
    }
    this.disruptor.handleEventsWithWorkerPool(workHandlers);
    this.disruptor.start();
    this.setState(LifecycleState.STARTED);
  }

  @Override
  public void shutdown() {
    if (this.disruptor != null) {
      this.setState(LifecycleState.STOPPING);
      this.disruptor.shutdown();
      this.disruptor = null;
      this.setState(LifecycleState.STOPPED);
    }
  }

  @Override
  public Monitor threadMonitor() {
    return this.threadMonitor;
  }

  @Override
  public ContextConfiguration getContextConfiguration() {
    return this.contextConfiguration;
  }
}
