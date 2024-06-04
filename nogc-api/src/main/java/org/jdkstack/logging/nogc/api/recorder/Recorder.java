package org.jdkstack.logging.nogc.api.recorder;

import org.jdkstack.logging.nogc.api.component.Component;

/**
 * This is a class description.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public interface Recorder extends Component {

  void log(String logLevel, String dateTime, String message);

  void log(String logLevel, String dateTime, String message, Object arg1);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9);

  void log(String logLevel, String dateTime, String message, Throwable thrown);

  void log(String logLevel, String dateTime, String message, Object arg1, Throwable thrown);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Throwable thrown);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Throwable thrown);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Throwable thrown);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Throwable thrown);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Throwable thrown);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Throwable thrown);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Throwable thrown);

  void log(String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @param message  .
   * @author admin
   */
  void log(String logLevel, String message);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @author admin
   */
  void log(String logLevel, String message, Object arg1);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param arg4     .
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4);

  /**
   * This is a method description.
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
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5);

  /**
   * This is a method description.
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
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6);

  /**
   * This is a method description.
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
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7);

  /**
   * This is a method description.
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
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8);

  /**
   * This is a method description.
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
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9);

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
  void log(String logLevel, String message, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param thrown   .
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param thrown   .
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param thrown   .
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param arg4     .
   * @param thrown   .
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Throwable thrown);

  /**
   * This is a method description.
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
   * @param thrown   .
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Throwable thrown);

  /**
   * This is a method description.
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
   * @param thrown   .
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Throwable thrown);

  /**
   * This is a method description.
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
   * @param thrown   .
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Throwable thrown);

  /**
   * This is a method description.
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
   * @param thrown   .
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Throwable thrown);

  /**
   * This is a method description.
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
   * @author admin
   */
  void log(String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @param index    .
   * @param message  .
   * @author admin
   */
  void log(int index, String logLevel, String message);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param arg4     .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param arg4     .
   * @param arg5     .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param arg4     .
   * @param arg5     .
   * @param arg6     .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param arg4     .
   * @param arg5     .
   * @param arg6     .
   * @param arg7     .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
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
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
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
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param thrown   .
   * @author admin
   */
  void log(int index, String logLevel, String message, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param thrown   .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param thrown   .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param thrown   .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param arg4     .
   * @param thrown   .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param arg4     .
   * @param arg5     .
   * @param thrown   .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param arg4     .
   * @param arg5     .
   * @param arg6     .
   * @param thrown   .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
   * @param logLevel .
   * @param message  .
   * @param arg1     .
   * @param arg2     .
   * @param arg3     .
   * @param arg4     .
   * @param arg5     .
   * @param arg6     .
   * @param arg7     .
   * @param thrown   .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
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
   * @param thrown   .
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
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
   * @author admin
   */
  void log(int index, String logLevel, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Throwable thrown);

  void log(int index, String logLevel, String dateTime, String message);

  void log(int index, String logLevel, String dateTime, String message, Object arg1);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param index    .
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
   * @author admin
   */
  void process(int index, String logLevel, String name, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Throwable thrown);

  void log(int index, String logLevel, String dateTime, String message, Throwable thrown);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Throwable thrown);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Throwable thrown);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Throwable thrown);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Throwable thrown);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Throwable thrown);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Throwable thrown);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Throwable thrown);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Throwable thrown);

  void log(int index, String logLevel, String dateTime, String message, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Throwable thrown);
}
