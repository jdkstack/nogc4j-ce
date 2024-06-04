package org.jdkstack.logging.nogc.core.thread.monitor;

import java.util.HashMap;
import java.util.Map;
import org.jdkstack.logging.nogc.api.thread.monitor.Monitor;
import org.jdkstack.logging.nogc.core.thread.utils.LongCache;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public class ThreadMonitor implements Monitor {

  /** . */
  public final Map<Long, Thread> threads = new HashMap<>(32);

  public ThreadMonitor() {
    //
  }

  @Override
  public final void registerThread(final Thread thread) {
    long id = thread.getId();
    this.threads.put(LongCache.cache[(int) id], thread);
  }

  @Override
  public final boolean isNull(long id) {
    if (this.threads.get(LongCache.cache[(int) id]) == null) {
      return true;
    }
    return false;
  }
}
