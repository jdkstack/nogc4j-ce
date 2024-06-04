package org.jdkstack.logging.nogc.api.handler;

import org.jdkstack.logging.nogc.api.component.Component;
import org.jdkstack.logging.nogc.api.record.Record;

/**
 * This is a class description.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public interface Handler extends Component {

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param lr .
   * @author admin
   */
  void consume(final Record lr) throws Exception;

  /**
   * This is a method description.
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
}
