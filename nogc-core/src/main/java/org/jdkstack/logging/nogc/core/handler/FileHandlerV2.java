package org.jdkstack.logging.nogc.core.handler;

import java.io.RandomAccessFile;
import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.api.context.LogComponentContext;
import org.jdkstack.logging.nogc.api.policy.TriggeringPolicy;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThread;
import org.jdkstack.logging.nogc.core.thread.utils.ThreadLocalTool;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public class FileHandlerV2 extends AbstractHandler {

  public FileHandlerV2(final LogComponentContext context) {
    super(context);
  }

  @Override
  public void rules(final Record lr) throws Exception {
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    final RandomAccessFile randomAccessFile = logConsumeThread.getRandomAccessFile();
    final HandlerConfig rc = this.context.getHandlerConfig(lr.getName());
    if (null == randomAccessFile) {
      logConsumeThread.setRc(rc);
      final TriggeringPolicy policy = this.context.findPolicy(rc.getPolicy());
      policy.remap(lr);
    } else {
      final TriggeringPolicy policy = this.context.findPolicy(rc.getPolicy());
      policy.isTriggeringEvent(lr);
    }
  }
}