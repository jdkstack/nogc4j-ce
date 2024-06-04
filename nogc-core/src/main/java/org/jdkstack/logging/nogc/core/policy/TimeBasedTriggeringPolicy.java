package org.jdkstack.logging.nogc.core.policy;

import org.jdkstack.logging.nogc.api.buffer.ByteWriter;
import org.jdkstack.logging.nogc.api.context.LogComponentContext;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThread;
import org.jdkstack.logging.nogc.core.thread.utils.ThreadLocalTool;

public class TimeBasedTriggeringPolicy extends AbstractTriggeringPolicy {

  /** . */
  private LogComponentContext context;
  /** . */
  private long intervalValue = 1L;
  /** . */
  private String intervalName = "day";

  public TimeBasedTriggeringPolicy(final LogComponentContext context) {
    this.context = context;
  }

  @Override
  public boolean isTriggeringEvent(Record logEvent) throws Exception {
    final long merge = getMerge(logEvent);
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    final ByteWriter destination = logConsumeThread.getDestination();
    final long mergeValue = destination.getMerge().get();
    if (mergeValue == -1L) {
      destination.getMerge().set(merge);
    } else if (mergeValue != merge) {
      this.remap(logEvent);
      destination.getMerge().set(merge);
    }
    return false;
  }

  public long getMerge(final Record logRecord) {
    final long interval;
    switch (intervalName) {
      case "second":
        interval = logRecord.getSeconds();
        break;
      case "minute":
        interval = logRecord.getMinutes();
        break;
      case "hour":
        interval = logRecord.getHours();
        break;
      case "day":
        interval = logRecord.getDay();
        break;
      case "month":
        interval = logRecord.getMonth();
        break;
      default:
        throw new RuntimeException("Not support.");
    }
    final long remainder = interval % this.intervalValue;
    return interval - remainder;
  }

  public long getIntervalValue() {
    return this.intervalValue;
  }

  public void setIntervalValue(final long intervalValue) {
    this.intervalValue = intervalValue;
  }

  public String getIntervalName() {
    return this.intervalName;
  }

  public void setIntervalName(final String intervalName) {
    this.intervalName = intervalName;
  }
}
