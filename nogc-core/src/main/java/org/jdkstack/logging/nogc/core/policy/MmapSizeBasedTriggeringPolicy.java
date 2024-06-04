package org.jdkstack.logging.nogc.core.policy;

import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.jdkstack.logging.nogc.api.buffer.ByteWriter;
import org.jdkstack.logging.nogc.api.config.ContextConfiguration;
import org.jdkstack.logging.nogc.api.context.LogComponentContext;
import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.core.thread.LogConsumeThread;
import org.jdkstack.logging.nogc.core.thread.utils.ThreadLocalTool;

public class MmapSizeBasedTriggeringPolicy extends SizeBasedTriggeringPolicy {

  private final LogComponentContext context;

  public MmapSizeBasedTriggeringPolicy(final LogComponentContext context) {
    super(context);
    this.context = context;
  }

  @Override
  public boolean isTriggeringEvent(Record logEvent) throws Exception {
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    final ByteWriter destination = logConsumeThread.getDestination();
    final MappedByteBuffer mappedBuffer = logConsumeThread.getMappedBuffer();
    final int chunk = mappedBuffer.remaining();
    final long size = destination.getSingleSizes().get();
    if (size > chunk) {
      this.remap(logEvent);
    }
    return false;
  }

  @Override
  public void remap(final Record lr) throws Exception {
    final LogConsumeThread logConsumeThread = ThreadLocalTool.getLogConsumeThread();
    MappedByteBuffer mappedBuffer = logConsumeThread.getMappedBuffer();
    if (null != mappedBuffer) {
      final ByteWriter destination = logConsumeThread.getDestination();
      destination.flush();
      final FileChannel channel = logConsumeThread.getChannel();
      channel.force(true);
      mappedBuffer.force();
      final Field field = mappedBuffer.getClass().getDeclaredField("cleaner");
      field.setAccessible(true);
      final Object cleaner = field.get(mappedBuffer);
      final Method cleanMethod = cleaner.getClass().getMethod("clean");
      cleanMethod.setAccessible(true);
      cleanMethod.invoke(cleaner);
    }
    super.remap(lr);
    final RandomAccessFile randomAccessFile = logConsumeThread.getRandomAccessFile();
    final FileChannel channel = randomAccessFile.getChannel();
    final ContextConfiguration contextConfiguration = context.getContextConfiguration();
    mappedBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, contextConfiguration.getRegionLength());
    mappedBuffer.order(ByteOrder.nativeOrder());
    logConsumeThread.setMappedBuffer(mappedBuffer);
    final ByteWriter destination = logConsumeThread.getMmapByteArrayWriter();
    destination.setDestination(mappedBuffer);
  }
}
