package org.jdkstack.logging.nogc.core.datetime;

import org.jdkstack.logging.nogc.api.datetime.Decoder;

/**
 * <a href="https://howardhinnant.github.io/date_algorithms.html">Howard Hinnant</a>.
 * <p>This tool can represent the AD era (0001-9999), BC era (- N-0000), and BC era (+10000-+N years)
 * <p>Currently, only 0 time zone date time formats can be converted to UTC0 time zone milliseconds
 *
 * <pre>
 * Input: 2022-11-05T23:05:01.105Z (supports other time zones)
 * Return: 1667660701105 (UTC time zone milliseconds)
 * Note: nanoseconds and microseconds are not supported and must contain milliseconds (future support).
 *
 * ISO 8601 Date Representation:
 * The Gregorian calendar consists of four digits, with the first year in the Gregorian calendar being 0001, the month being two digits (01-12), and the day being two digits (01-31)
 * The BC era starts with -, with the Gregorian calendar year 1 BC being 0000, the Gregorian calendar year 2 BC being -0001, the month being 2-digit (01-12), and the day being 2-digit (01-31)
 * The year after the Gregorian calendar starts with+, and the year after the Gregorian calendar is+10000. The month is a 2-digit number (01-12), and the day is a 2-digit number (01-31)
 * ISO 8601 Time Representation:
 * Hours (00-23), minutes, and seconds are all represented by 2-digits (00-59), and milliseconds must be 3-digits (000-999).
 * If 2:30pm and 5pm UTC time is used, it means 14:30:05.000Z (other representations are not supported).
 * Combination representation of ISO 8601 date and time:
 * When merging representations, add a capital letter T before the time.
 * If you want to represent May 3, 2004 at 5:30pm and 8:00pm UTC time, you can write it as 2004-05-03T17:30:08.000Z.
 * </pre>
 *
 * @author admin
 */
public class DateTimeDecoder implements Decoder {

  private DateTimeDecoder() {
    //
  }

  /**
   * .
   *
   * <p>.
   *
   * @param dateTime .
   * @param offset   .
   * @return long .
   * @author admin
   */
  public static long decoder(final StringBuilder dateTime, final long offset) {
    long year = year(dateTime);
    final long mon = month(dateTime);
    final long day = day(dateTime);
    final long hour = hours(dateTime);
    final long min = minutes(dateTime);
    final long sed = seconds(dateTime);
    final long mis = millisecond(dateTime);
    if (2 >= mon) {
      year -= 1;
    }
    final long era;
    if (0 <= year) {
      era = year / Constants.N400;
    } else {
      era = (year - Constants.N399) / Constants.N400;
    }
    final long doy;
    if (Constants.N2 < mon) {
      doy = (Constants.N153 * (mon - Constants.N3) + Constants.N2) / Constants.N5 + day - Constants.N1;
    } else {
      doy = (Constants.N153 * (mon + Constants.N9) + Constants.N2) / Constants.N5 + day - Constants.N1;
    }
    final long yoe = year - era * Constants.N400;
    final long doe = yoe * Constants.N365 + yoe / Constants.N4 - yoe / Constants.N100 + doy;
    final long dayCount = era * Constants.N146097 + doe - Constants.DAYS_0000_TO_1970_MARCH_ONE;
    long msSecond = (dayCount * Constants.N24 * Constants.N60 * Constants.N60 + offset) * Constants.N1000;
    msSecond += hour * Constants.N60 * Constants.N60 * Constants.N1000;
    msSecond += min * Constants.N60 * Constants.N1000;
    msSecond += sed * Constants.N1000;
    msSecond += mis;
    return msSecond;
  }

  /**
   * .
   *
   * <p>Another description after blank line.
   *
   * @param dateTime .
   * @return long .
   * @author admin
   */
  public static long decoder(final StringBuilder dateTime) {
    return decoder(dateTime, 0);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param dateTime .
   * @return long .
   * @author admin
   */
  public static long year(final StringBuilder dateTime) {
    return read(dateTime, Constants.N1);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param dateTime .
   * @return long .
   * @author admin
   */
  public static long month(final StringBuilder dateTime) {
    return read(dateTime, Constants.N2);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param dateTime .
   * @return long .
   * @author admin
   */
  public static long day(final StringBuilder dateTime) {
    return read(dateTime, Constants.N3);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param dateTime .
   * @return long .
   * @author admin
   */
  public static long hours(final StringBuilder dateTime) {
    return read(dateTime, Constants.N4);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param dateTime .
   * @return long .
   * @author admin
   */
  public static long minutes(final StringBuilder dateTime) {
    return read(dateTime, Constants.N5);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param dateTime .
   * @return long .
   * @author admin
   */
  public static long seconds(final StringBuilder dateTime) {
    return read(dateTime, Constants.N6);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param dateTime .
   * @return long .
   * @author admin
   */
  public static long millisecond(final StringBuilder dateTime) {
    return read(dateTime, Constants.N7);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param dateTime .
   * @param type     .
   * @return long .
   * @author admin
   */
  public static long read(final StringBuilder dateTime, final int type) {
    int index = 0;
    int x = 0;
    int y = 0;
    final char c1 = dateTime.charAt(index);
    if ('+' == c1) {
      index++;
      x = 1;
    }
    if ('-' == c1) {
      index++;
      x = -1;
    }
    final int len = dateTime.length();
    long total = 0;
    long value = 0;
    int state = 0;
    while (index < len) {
      final char c = dateTime.charAt(index);
      switch (c) {
        case 'T':
          if (2 == state) {
            value = total;
            total = 0;
            state = 3;
            if (3 == type) {
              index = len;
            }
          }
          break;
        case ':':
          if (3 == state) {
            value = total;
            total = 0;
            state = 4;
            if (4 == type) {
              index = len;
            }
          } else if (4 == state) {
            value = total;
            total = 0;
            state = 5;
            if (5 == type) {
              index = len;
            }
          } else if (7 == state) {
            total = total * 3600;
            value = total;
            total = 0;
            state = 8;
          }
          break;
        case '.':
          if (5 == state) {
            value = total;
            total = 0;
            state = 6;
            if (6 == type) {
              index = len;
            }
          }
          break;
        case '+':
          if (6 == state) {
            y = 1;
            value = total;
            total = 0;
            state = 7;
            if (7 == type) {
              index = len;
            }
          }
          break;
        case '-':
          if (0 == state) {
            state = 1;
            if (1 == x) {
              value = +total;
            }
            if (-1 == x) {
              value = -total;
            }
            if (0 == x) {
              value = +total;
            }
            total = 0;
            if (1 == type) {
              index = len;
            }
          } else if (1 == state) {
            state = 2;
            value = total;
            total = 0;
            if (2 == type) {
              index = len;
            }
          } else if (6 == state) {
            y = -1;
            state = 7;
            value = total;
            total = 0;
            if (7 == type) {
              index = len;
            }
          }
          break;
        case 'Z':
          if (6 == state) {
            y = 0;
            state = 10;
            value = total;
            total = 0;
            if (7 == type) {
              index = len;
            }
          }
          break;
        default:
          final long temp1 = total * 10;
          total = temp1 + (c - '0');
          break;
      }
      index++;
    }
    if (10 == state) {
      value = value;
    }
    if (8 == state) {
      total = total * 60;
      value = value + total;
      total = 0;
      if (8 == type) {
        index = len;
      }
      if (1 == y) {
        value = value;
      }
      if (-1 == y) {
        value = -value;
      }
      if (0 == y) {
        value = 0;
      }
    }
    return value;
  }
}
