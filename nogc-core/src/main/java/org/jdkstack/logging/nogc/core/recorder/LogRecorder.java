package org.jdkstack.logging.nogc.core.recorder;

import org.jdkstack.logging.nogc.api.config.RecorderConfig;
import org.jdkstack.logging.nogc.api.context.LogComponentContext;
import org.jdkstack.logging.nogc.api.recorder.Recorder;

/**
 * .
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public class LogRecorder implements Recorder {

  /** . */
  private final LogComponentContext context;
  /** . */
  private RecorderConfig recorderConfig;

  public LogRecorder(final LogComponentContext context, final RecorderConfig recorderConfig) {
    this.context = context;
    this.recorderConfig = recorderConfig;
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message) {
    this.core(0, logLevel, dateTime, message, null, null, null, null, null, null, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1) {
    this.core(0, logLevel, dateTime, message, arg1, null, null, null, null, null, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, null, null, null, null, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, null, null, null, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, arg4, null, null, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, null, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null, null);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Object arg9) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, null);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Throwable thrown) {
    this.core(0, logLevel, dateTime, message, null, null, null, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Throwable thrown) {
    this.core(0, logLevel, dateTime, message, arg1, null, null, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Throwable thrown) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, null, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Throwable thrown) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Throwable thrown) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, arg4, null, null, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Throwable thrown) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, null, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Throwable thrown) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Throwable thrown) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Throwable thrown) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Object arg9, final Throwable thrown) {
    this.core(0, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, thrown);
  }

  @Override
  public void log(final String logLevel, final String message) {
    this.core(0, logLevel, null, message, null, null, null, null, null, null, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1) {
    this.core(0, logLevel, null, message, arg1, null, null, null, null, null, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2) {
    this.core(0, logLevel, null, message, arg1, arg2, null, null, null, null, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, null, null, null, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, arg4, null, null, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, null, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, null, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, null, null, null);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null, null);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Object arg9) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, null);
  }

  @Override
  public void log(final String logLevel, final String message, final Throwable thrown) {
    this.core(0, logLevel, null, message, null, null, null, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Throwable thrown) {
    this.core(0, logLevel, null, message, arg1, null, null, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Throwable thrown) {
    this.core(0, logLevel, null, message, arg1, arg2, null, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Throwable thrown) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Throwable thrown) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, arg4, null, null, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Throwable thrown) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, null, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Throwable thrown) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, null, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Throwable thrown) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, null, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Throwable thrown) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null, thrown);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Object arg9, final Throwable thrown) {
    this.core(0, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, thrown);
  }

  @Override
  public void log(int index, String logLevel, String message) {
    this.core(index, logLevel, null, message, null, null, null, null, null, null, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1) {
    this.core(index, logLevel, null, message, arg1, null, null, null, null, null, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2) {
    this.core(index, logLevel, null, message, arg1, arg2, null, null, null, null, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, null, null, null, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, arg4, null, null, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, null, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null, null);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, null);
  }

  @Override
  public void log(int index, String logLevel, String message, Throwable thrown) {
    this.core(index, logLevel, null, message, null, null, null, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Throwable thrown) {
    this.core(index, logLevel, null, message, arg1, null, null, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Throwable thrown) {
    this.core(index, logLevel, null, message, arg1, arg2, null, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Throwable thrown) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Throwable thrown) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, arg4, null, null, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Throwable thrown) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, null, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Throwable thrown) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Throwable thrown) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Throwable thrown) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Throwable thrown) {
    this.core(index, logLevel, null, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, thrown);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Throwable thrown) {
    this.core(index, logLevel, dateTime, message, null, null, null, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Throwable thrown) {
    this.core(index, logLevel, dateTime, message, arg1, null, null, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Throwable thrown) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, null, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Throwable thrown) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, null, null, null, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Throwable thrown) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, arg4, null, null, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Throwable thrown) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, null, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Throwable thrown) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, null, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Throwable thrown) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, null, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Throwable thrown) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null, thrown);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Throwable thrown) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, thrown);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message) {
    this.core(index, logLevel, dateTime, message, null, null, null, null, null, null, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1) {
    this.core(index, logLevel, dateTime, message, arg1, null, null, null, null, null, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, null, null, null, null, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, null, null, null, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, arg4, null, null, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, null, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, null, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, null, null, null);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null, null);
  }

  @Override
  public void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9) {
    this.core(index, logLevel, dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, null);
  }

  @Override
  public void process(int index, final String logLevel, final String name, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Object arg9, final Throwable thrown) {
    if (this.context.doFilter(logLevel, this.recorderConfig.getMaxLevelValue(), this.recorderConfig.getMinLevelValue())) {
      final String state = this.recorderConfig.getState();
      switch (state) {
        case "synchronous":
          this.context.synchronous(index, logLevel, dateTime, message, name, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, thrown);
          break;
        case "asynchronous":
          this.context.asynchronous(index, logLevel, dateTime, message, name, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, thrown);
          break;
        default:
          throw new RuntimeException("Not support.");
      }
    }
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @param message  .
   * @param thrown   .
   * @author admin
   */
  public void core(int index, final String logLevel, final String dateTime, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Object arg9, final Throwable thrown) {
    this.process(index, logLevel, this.recorderConfig.getName(), dateTime, message, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, thrown);
  }
}
