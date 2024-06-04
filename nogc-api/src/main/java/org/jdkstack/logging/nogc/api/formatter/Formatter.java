package org.jdkstack.logging.nogc.api.formatter;

import org.jdkstack.logging.nogc.api.component.Component;
import org.jdkstack.logging.nogc.api.record.Record;

/**
 * This is a method description.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public interface Formatter extends Component {

  /**
   * .
   *
   * <p>.
   *
   * @param logRecord .
   * @return .
   * @author admin
   */
  StringBuilder format(Record logRecord);
}
