package org.jdkstack.logging.nogc.api.lifecycle;

/**
 * .
 *
 * @author admin
 */
public interface Lifecycle {

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return LifecycleState  .
   * @author admin
   */
  LifecycleState getState();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param state .
   * @author admin
   */
  void setState(LifecycleState state);
}
