package org.jdkstack.logging.nogc.core.policy;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import org.jdkstack.logging.nogc.api.buffer.ByteWriter;
import org.jdkstack.logging.nogc.api.policy.TriggeringPolicy;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThread;
import org.jdkstack.logging.nogc.core.thread.utils.ThreadLocalTool;

public abstract class AbstractTriggeringPolicy implements TriggeringPolicy {

  @Override
  public void remap(final Record lr) throws Exception {
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    RandomAccessFile randomAccessFile = logConsumeThread.getRandomAccessFile();
    if (null != randomAccessFile) {
      final ByteWriter destination = logConsumeThread.getDestination();
      destination.flush();
      final FileChannel channel = logConsumeThread.getChannel();
      channel.force(true);
    }
    randomAccessFile = logConsumeThread.getRandomAccessFileBuffer().poll();
    logConsumeThread.setRandomAccessFile(randomAccessFile);
    logConsumeThread.setChannel(randomAccessFile.getChannel());
    final ByteWriter destination = logConsumeThread.getDestination();
    destination.setDestination(randomAccessFile);
  }
}
