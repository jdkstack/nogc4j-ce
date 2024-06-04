package org.jdkstack.logging.nogc.core.thread.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThread;
import org.jdkstack.logging.nogc.core.thread.LogProduceThread;

public class ThreadLocalTool {

  private static final Map<Long, LogConsumeThread> logConsumeThreads = new HashMap<>();
  private static final Map<Long, LogProduceThread> logProduceThreads = new HashMap<>();
  private static final Map<Long, List<LogProduceThread>> bigTables = new HashMap<>();

  public static LogConsumeThread getLogConsumeThread() {
    final Thread thread = Thread.currentThread();
    LogConsumeThread logConsumeThread;
    if (thread instanceof LogConsumeThread) {
      logConsumeThread = (LogConsumeThread) Thread.currentThread();
    } else {
      final long id = thread.getId();
      logConsumeThread = logConsumeThreads.get(LongCache.cache[(int) id]);
      if (logConsumeThread == null) {
        logConsumeThread = new LogConsumeThread(null, "log-c");
        logConsumeThreads.put(LongCache.cache[(int) id], logConsumeThread);
      }
    }
    return logConsumeThread;
  }

  public static LogProduceThread getLogProduceThread() {
    final Thread thread = Thread.currentThread();
    LogProduceThread logProduceThread;
    if (thread instanceof LogProduceThread) {
      logProduceThread = (LogProduceThread) Thread.currentThread();
    } else {
      final long id = thread.getId();
      logProduceThread = logProduceThreads.get(LongCache.cache[(int) id]);
      if (logProduceThread == null) {
        logProduceThread = new LogProduceThread(null, "log-p");
        logProduceThreads.put(LongCache.cache[(int) id], logProduceThread);
      }
    }
    return logProduceThread;
  }

  public static LogProduceThread getLogProduceThread(long id) {
    return logProduceThreads.get(LongCache.cache[(int) id]);
  }

  public static LogConsumeThread getLogConsumeThread(long id) {
    return logConsumeThreads.get(LongCache.cache[(int) id]);
  }

  public static void putLogThread(long id, LogProduceThread thread) {
    List<LogProduceThread> list = getLogThread(LongCache.cache[(int) id]);
    if (list != null) {
      if (!list.contains(thread)) {
        list.add(thread);
      }
    } else {
      list = new ArrayList<>();
      list.add(thread);
      bigTables.put(LongCache.cache[(int) id], list);
    }
  }

  public static List<LogProduceThread> getLogThread(long id) {
    return bigTables.get(LongCache.cache[(int) id]);
  }
}
