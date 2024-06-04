package org.jdkstack.logging.nogc.api.lifecycle;

public enum LifecycleState {
  /**  */
  SETUP(true, "SETUP"),
  /**  */
  INITIALIZING(true, "INITIALIZING"),
  /**  */
  INITIALIZED(true, "INITIALIZED"),
  /**  */
  STARTING(true, "STARTING"),
  /**  */
  STARTED(true, "STARTED"),
  /**  */
  STOPPING(true, "STOPPING"),
  /**  */
  STOPPED(true, "STOPPED");

  private final boolean available;
  private final String lifecycleEvent;

  LifecycleState(boolean available, String lifecycleEvent) {
    this.available = available;
    this.lifecycleEvent = lifecycleEvent;
  }

  public boolean isAvailable() {
    return available;
  }

  public String getLifecycleEvent() {
    return lifecycleEvent;
  }
}
