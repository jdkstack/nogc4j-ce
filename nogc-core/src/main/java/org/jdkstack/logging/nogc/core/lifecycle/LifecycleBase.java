package org.jdkstack.logging.nogc.core.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import org.jdkstack.logging.nogc.api.lifecycle.Lifecycle;
import org.jdkstack.logging.nogc.api.lifecycle.LifecycleState;

public abstract class LifecycleBase implements Lifecycle {

  private AtomicReference<LifecycleState> state = new AtomicReference<>(LifecycleState.SETUP);

  @Override
  public LifecycleState getState() {
    return state.get();
  }

  @Override
  public void setState(final LifecycleState state) {
    this.state.set(state);
  }
}
