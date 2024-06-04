package org.jdkstack.logging.nogc.core.policy;

import org.jdkstack.logging.nogc.api.buffer.ByteWriter;
import org.jdkstack.logging.nogc.api.context.LogComponentContext;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThread;
import org.jdkstack.logging.nogc.core.thread.utils.ThreadLocalTool;

public class LineBasedTriggeringPolicy extends AbstractTriggeringPolicy {

  /** 100W. */
  private int lineMax = 1000000;

  public LineBasedTriggeringPolicy(final LogComponentContext context) {

  }

  @Override
  public boolean isTriggeringEvent(Record logEvent) throws Exception {
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    final ByteWriter destination = logConsumeThread.getDestination();
    final long line = destination.getLines().get();
    if (lineMax <= line) {
      this.remap(logEvent);
    }
    return false;
  }

  public int getLineMax() {
    return this.lineMax;
  }

  public void setLineMax(final int lineMax) {
    this.lineMax = lineMax;
  }
}
