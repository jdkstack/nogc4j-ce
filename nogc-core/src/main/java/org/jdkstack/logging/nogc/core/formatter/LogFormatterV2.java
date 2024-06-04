package org.jdkstack.logging.nogc.core.formatter;

import org.jdkstack.logging.nogc.api.record.Record;
import org.jdkstack.logging.nogc.core.tool.Unboxing;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public class LogFormatterV2 {

  private LogFormatterV2() {
    //
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param message message.
   * @param lr      lr.
   * @author admin
   */
  public static void format(final Record lr, final String message) {
    final int length = message.length();
    int placeholderCount = 0;
    for (int i = 0; i < length - 1; i++) {
      final char curChar = message.charAt(i);
      if (curChar == '{' && message.charAt(i + 1) == '}') {
        // {} max count is 9,Ignore all subsequent {}.
        if (placeholderCount == 9) {
          break;
        }
        lr.setPaths(i, placeholderCount);
        placeholderCount++;
        i++;
      }
    }
    final StringBuilder sb = lr.getMessageText();
    final Object[] params = lr.getParams();
    final int[] paths = lr.getPaths();
    int previous = 0;
    for (int i = 0; i < placeholderCount; i++) {
      sb.append(message, previous, paths[i]);
      previous = paths[i] + 2;
      Unboxing.unbox(sb, params[i]);
    }
    sb.append(message, previous, length);
  }
}
