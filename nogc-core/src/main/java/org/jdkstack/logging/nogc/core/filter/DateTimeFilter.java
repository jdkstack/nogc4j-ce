package org.jdkstack.logging.nogc.core.filter;

import org.jdkstack.logging.nogc.api.record.Record;

public class DateTimeFilter extends AbstractFilter {

  public DateTimeFilter() {
    //
  }

  @Override
  public boolean doFilter(final Record logRecord) {
    return logRecord.getMinutes() >= 45;
  }
}
