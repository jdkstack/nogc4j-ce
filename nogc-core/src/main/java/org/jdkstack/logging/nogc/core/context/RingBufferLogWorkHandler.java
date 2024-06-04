package org.jdkstack.logging.nogc.core.context;

import com.lmax.disruptor.WorkHandler;
import org.jdkstack.logging.nogc.api.context.LogComponentContext;
import org.jdkstack.logging.nogc.api.record.Record;

public class RingBufferLogWorkHandler implements WorkHandler<Record> {

  private LogComponentContext context;

  public RingBufferLogWorkHandler(LogComponentContext context) {
    this.context = context;
  }

  @Override
  public void onEvent(Record event) throws Exception {
    try {
      context.consume(event);
    } finally {
      event.clear();
    }
  }
}
