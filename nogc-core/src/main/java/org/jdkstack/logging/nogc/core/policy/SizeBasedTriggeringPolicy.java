package org.jdkstack.logging.nogc.core.policy;

import org.jdkstack.logging.nogc.api.buffer.ByteWriter;
import org.jdkstack.logging.nogc.api.context.LogComponentContext;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThread;
import org.jdkstack.logging.nogc.core.thread.utils.ThreadLocalTool;

public class SizeBasedTriggeringPolicy extends AbstractTriggeringPolicy {

  /** 100MB. */
  private int sizeMax = 104857600;

  public SizeBasedTriggeringPolicy(final LogComponentContext context) {

  }

  @Override
  public boolean isTriggeringEvent(Record logEvent) throws Exception {
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    final ByteWriter destination = logConsumeThread.getDestination();
    final long size = destination.getSizes().get();
    if (sizeMax <= size) {
      this.remap(logEvent);
    }
    return false;
  }
}
