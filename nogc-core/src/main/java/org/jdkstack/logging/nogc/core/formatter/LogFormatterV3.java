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
public class LogFormatterV3 {

  private LogFormatterV3() {
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
    final StringBuilder sb = lr.getMessageText();
    final Object[] params = lr.getParams();
    for (int i = 0; i < length - 1; i++) {
      final char curChar = message.charAt(i);
      if (curChar == '{' && message.charAt(i + 1) == '}') {
        // {} max count is 9,Ignore all subsequent {}.
        Unboxing.unbox(sb, params[placeholderCount]);
        if (placeholderCount == 9) {
          break;
        }
        placeholderCount++;
        i++;
      } else {
        sb.append(curChar);
      }
    }
  }
}

