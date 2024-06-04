package org.jdkstack.logging.nogc.api.thread.monitor;

/**
 * This is a class description.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public interface Monitor {

  /**
   * .
   *
   * <p>.
   *
   * @param thread .
   * @author admin
   */
  default void registerThread(final Thread thread) {
    //
  }

  /**
   * .
   *
   * <p>.
   *
   * @param id .
   * @author admin
   */
  boolean isNull(long id);
}
