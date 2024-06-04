package org.jdkstack.logging.nogc.api.policy;

import org.jdkstack.logging.nogc.api.record.Record;

public interface TriggeringPolicy {

  boolean isTriggeringEvent(final Record logEvent) throws Exception;

  void remap(final Record lr) throws Exception;
}
