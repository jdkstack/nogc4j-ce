package org.jdkstack.logging.nogc.core.handler;

import java.nio.MappedByteBuffer;
import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.api.context.LogComponentContext;
import org.jdkstack.logging.nogc.api.policy.TriggeringPolicy;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThread;
import org.jdkstack.logging.nogc.core.thread.utils.ThreadLocalTool;

/**
 * .
 *
 * <p> .
 *
 * @author admin
 */
public class MmapFileHandlerV2 extends FileHandlerV2 {

  private final LogComponentContext context;

  public MmapFileHandlerV2(final LogComponentContext context) {
    super(context);
    this.context = context;
  }

  @Override
  public final void rules(final Record lr) throws Exception {
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    final MappedByteBuffer mappedBuffer = logConsumeThread.getMappedBuffer();
    final HandlerConfig rc = this.context.getHandlerConfig(lr.getName());
    if (null == mappedBuffer) {
      logConsumeThread.setRc(rc);
      final TriggeringPolicy policy = this.context.findPolicy(rc.getPolicy());
      policy.remap(lr);
    } else {
      final TriggeringPolicy policy = this.context.findPolicy(rc.getPolicy());
      policy.isTriggeringEvent(lr);
    }
  }
}
