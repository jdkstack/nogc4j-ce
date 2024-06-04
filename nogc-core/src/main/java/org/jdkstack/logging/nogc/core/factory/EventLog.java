package org.jdkstack.logging.nogc.core.factory;

import org.jdkstack.logging.nogc.api.context.LogComponentContextFactory;
import org.jdkstack.logging.nogc.api.factory.Log;
import org.jdkstack.logging.nogc.api.recorder.Recorder;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public class EventLog implements Log {

  /** . */
  public String name;
  /** . */
  public LogComponentContextFactory factory;

  public EventLog(final String name, final LogComponentContextFactory factory) {
    this.name = name;
    this.factory = factory;
  }

  @Override
  public void log(final String logLevel, final String datetime, final String message, final Throwable thrown) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8) {
    Recorder recorder = factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Object arg9) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Throwable thrown) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Throwable thrown) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Throwable thrown) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Throwable thrown) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Throwable thrown) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Throwable thrown) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Throwable thrown) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Throwable thrown) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Throwable thrown) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }

  @Override
  public void log(final String logLevel, final String message, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5, final Object arg6, final Object arg7, final Object arg8, final Object arg9, final Throwable thrown) {
    final Recorder recorder = this.factory.getRecorder(name);
    recorder.log(logLevel, message);
  }
}
