package org.jdkstack.logging.nogc.core.record;

import com.lmax.disruptor.EventFactory;
import org.jdkstack.logging.nogc.api.record.Record;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public class RecordEventFactory implements EventFactory<Record> {

  @Override
  public Record newInstance() {
    return new LogRecord();
  }
}
