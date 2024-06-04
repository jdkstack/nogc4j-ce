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
public class LogConsumeThreadFactory implements ThreadFactory {

  /** . */
  private final String prefix;
  /** . */
  private final AtomicInteger threadCount = new AtomicInteger(0);
  /** . */
  private final Monitor checker;

  public LogConsumeThreadFactory(final String prefix, final Monitor checkerParam) {
    this.prefix = prefix;
    this.checker = checkerParam;
  }

  @Override
  public Thread newThread(final Runnable runnable) {
    final int andIncrement = this.threadCount.getAndIncrement();
    final Thread thread = Thread.currentThread();
    final ThreadGroup threadGroup = thread.getThreadGroup();
    final String name = this.prefix + andIncrement;
    final ThreadGroup currentThreadGroup = new ThreadGroup(threadGroup, name);
    final Thread logThread = new LogConsumeThread(currentThreadGroup, runnable, name);
    if (null != this.checker) {
      this.checker.registerThread(logThread);
    }
    logThread.setDaemon(true);
    return logThread;
  }
}
