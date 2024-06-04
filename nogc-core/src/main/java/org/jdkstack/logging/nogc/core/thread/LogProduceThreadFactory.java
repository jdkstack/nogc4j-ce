package org.jdkstack.logging.nogc.core.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.jdkstack.logging.nogc.api.thread.monitor.Monitor;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public class LogProduceThreadFactory implements ThreadFactory {

  /** . */
  private final String prefix;
  /** . */
  private final AtomicInteger threadCount = new AtomicInteger(0);
  /** . */
  private final Monitor checker;

  public LogProduceThreadFactory(final String prefix, final Monitor checkerParam) {
    this.prefix = prefix;
    this.checker = checkerParam;
  }

  @Override
  public Thread newThread(final Runnable runnable) {
    final int andIncrement = this.threadCount.getAndIncrement();
    Thread thread = Thread.currentThread();
    ThreadGroup threadGroup = thread.getThreadGroup();
    String name = this.prefix + andIncrement;
    ThreadGroup currentThreadGroup = new ThreadGroup(threadGroup, name);
    final LogProduceThread logThread = new LogProduceThread(currentThreadGroup, runnable, name);
    if (null != this.checker) {
      this.checker.registerThread(logThread);
    }
    logThread.setDaemon(true);
    return logThread;
  }
}
