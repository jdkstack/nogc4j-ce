package org.jdkstack.logging.nogc.api.filter;

import org.jdkstack.logging.nogc.api.component.Component;
import org.jdkstack.logging.nogc.api.record.Record;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public interface Filter extends Component {

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logRecord .
   * @return b.
   * @author admin
   */
  boolean doFilter(Record logRecord);
}
