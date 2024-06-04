package org.jdkstack.logging.nogc.core.datetime;

import org.jdkstack.logging.nogc.api.datetime.Encoder;

/**
 * <a href="https://howardhinnant.github.io/date_algorithms.html">Howard Hinnant</a>.
 * <p>This tool can represent the AD era (0001-9999), BC era (- N-0000), and BC era (+10000-+N years)
 * <p>Currently, only UTC0 time zone milliseconds can be converted to any time zone date time format
 *
 * <pre>
 * Input: 1667660701105 (Input must be in UTC time zone milliseconds)
 * Return: 2022-11-05T23:05:01.105Z (supports other time zones)
 * Note: nanoseconds and microseconds are not supported and must contain milliseconds (future support).
 *
 * ISO 8601 Date Representation:
 * The Gregorian calendar consists of four digits, with the first year in the Gregorian calendar being 0001, the month being two digits (01-12), and the day being two digits (01-31)
 * The BCE era starts with -, with the Gregorian calendar having a year of 10000, a month with 2 digits (01-12), and a day with 2 digits (01-31)
 * The year after the Gregorian calendar starts with+, and the year after the Gregorian calendar is+10000. The month is a 2-digit number (01-12), and the day is a 2-digit number (01-31)
 * ISO 8601 Time Representation:
 * Hours (00-23), minutes, and seconds are all represented by 2-digits (00-59), and milliseconds must be 3-digits (000-999).
 * If the UTC time zone is 2:30pm and 5pm, it means 14:30:05.000Z (other representations are not supported).
 * Combination representation of ISO 8601 date and time:
 * When merging representations, add a capital letter T before the time.
 * If you want to represent the UTC0 time zone on May 3, 2004 at 5:30 pm and 8 seconds, you can write it as 2004-05-03T17:30:08.000Z.
 * </pre>
 *
 * @author admin
 */
public class DateTimeEncoder implements Encoder {

  /** . */
  private static final int SECOND_IN_MILLIS = 1000;
  /** . */
  private static final int MINUTE_IN_MILLIS = SECOND_IN_MILLIS * 60;
  /** . */
  private static final int HOUR_IN_MILLIS = MINUTE_IN_MILLIS * 60;
  /** . */
  private static final int DAY_IN_MILLIS = HOUR_IN_MILLIS * 24;
  /** . */
  private static final int EPOCH_OFFSET = 719163;

  private DateTimeEncoder() {
    //
  }

  /**
   * .
   *
   * <p>.
   *
   * @param millis .
   * @param offset .
   * @return StringBuilder .
   * @author admin
   */
  public static StringBuilder encoder(final StringBuilder sb, final long millis, final long offset) {
    final long secondUtc = millis / Constants.MILLS_PER_SECOND;
    final long localSecond = secondUtc + offset;
    final long todayTo1970 = Math.floorDiv(localSecond, Constants.SECONDS_PER_DAY);
    final long zeroToToday = todayTo1970 + Constants.DAYS_0000_TO_1970;
    final long zeroToTodayFrom3 = zeroToToday - 60;
    final long era;
    if (0 <= zeroToTodayFrom3) {
      era = zeroToTodayFrom3 / Constants.N146097;
    } else {
      era = (zeroToTodayFrom3 - Constants.N146096) / Constants.N146097;
    }
    final long temp1 = era * Constants.N146097;
    final long doe = zeroToTodayFrom3 - temp1;
    final long temp3 = doe / Constants.N1460;
    final long temp4 = doe / Constants.N36524;
    final long temp5 = doe / Constants.N146096;
    final long temp6 = doe - temp3 + temp4 - temp5;
    final long yoe = temp6 / Constants.N365;
    final long yp = era * Constants.N400;
    long year = yoe + yp;
    final long doy = doe - (Constants.N365 * yoe + yoe / 4 - yoe / Constants.N100);
    final long mp = (5 * doy + 2) / Constants.N153;
    final long month;
    if (Constants.N10 > mp) {
      month = mp + Constants.N3;
    } else {
      month = mp - Constants.N9;
    }
    if (2 >= month) {
      year += 1;
    }
    check3(sb, year);
    check(sb, month, '-');
    final long day = doy - (Constants.N153 * mp + 2) / 5 + 1;
    check(sb, day, '-');
    sb.append('T');
    final long secondOfDay = Math.floorMod(localSecond, Constants.SECONDS_PER_DAY);
    final long nanoSecondDay = secondOfDay * Constants.NANOS_PER_SECOND;
    final long millisecondUtc = millis % Constants.MILLS_PER_SECOND;
    final long nanoSecondUtc = millisecondUtc * Constants.NANOS_PER_MILLI;
    long nanoOfDay = nanoSecondDay + nanoSecondUtc;
    final long hour = nanoOfDay / Constants.NANOS_PER_HOUR;
    nanoOfDay -= hour * Constants.NANOS_PER_HOUR;
    final long minute = nanoOfDay / Constants.NANOS_PER_MINUTE;
    nanoOfDay -= minute * Constants.NANOS_PER_MINUTE;
    final long second = nanoOfDay / Constants.NANOS_PER_SECOND;
    nanoOfDay -= second * Constants.NANOS_PER_SECOND;
    final long millisecond = nanoOfDay / Constants.NANOS_PER_MILLI;
    check10(sb, hour);
    check(sb, minute, ':');
    check(sb, second, ':');
    check2(sb, millisecond);
    final long h = offset / 3_600;
    final long s = offset % 3_600;
    final long m = s / 60;
    if (0 < offset) {
      sb.append('+');
      if (10 > h) {
        sb.append('0');
        sb.append(h);
      } else {
        sb.append(h);
      }
      sb.append(':');
      if (10 > m) {
        sb.append('0');
        sb.append(m);
      } else {
        sb.append(m);
      }
    } else if (0 > offset) {
      if (-10 > h) {
        sb.append(h);
      } else {
        sb.append("-0");
        sb.append(-h);
      }
      sb.append(':');
      if (-10 > m) {
        sb.append(m);
      } else {
        sb.append("0");
        sb.append(m);
      }
    } else {
      sb.append('Z');
    }
    return sb;
  }

  /**
   * This is a class description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @return StringBuilder .
   * @author admin
   */
  public static StringBuilder encoder(final StringBuilder sb, final long millis) {
    return encoder(sb, millis, 0);
  }

  private static void check3(final StringBuilder sb, final long year) {
    if (Constants.N1000 > year) {
      if (0 > year) {
        if (-Constants.N9999 > year) {
          sb.append(year);
        } else {
          sb.append(year - Constants.N10000).deleteCharAt(1);
        }
      } else {
        sb.append(year + Constants.N10000).deleteCharAt(0);
      }
    } else {
      if (Constants.N9999 < year) {
        sb.append('+');
      }
      sb.append(year);
    }
  }

  private static void check2(final StringBuilder sb, final long value) {
    sb.append('.');
    if (Constants.N10 > value) {
      sb.append("00");
    } else if (Constants.N100 > value) {
      sb.append('0');
    }
    sb.append(value);
  }

  private static void check10(final StringBuilder sb, final long value) {
    if (Constants.N10 > value) {
      sb.append('0');
    }
    sb.append(value);
  }

  private static void check(final StringBuilder sb, final long value, final char symbol) {
    sb.append(symbol);
    if (Constants.N10 > value) {
      sb.append('0');
    }
    sb.append(value);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @param offset .
   * @return long .
   * @author admin
   */
  public static long year(final long millis, final long offset) {
    final long epochSecond = millis / 1000;
    final long localSecond = epochSecond + offset;
    final long localEpochDay = Math.floorDiv(localSecond, Constants.SECONDS_PER_DAY);
    final long zeroDay = localEpochDay + Constants.DAYS_0000_TO_1970 - 60;
    final long era;
    if (0 <= zeroDay) {
      era = zeroDay / Constants.N146097;
    } else {
      era = (zeroDay - Constants.N146096) / Constants.N146097;
    }
    final long temp1 = era * Constants.N146097;
    final long doe = zeroDay - temp1;
    final long temp3 = doe / Constants.N1460;
    final long temp4 = doe / Constants.N36524;
    final long temp5 = doe / Constants.N146096;
    final long temp6 = doe - temp3 + temp4 - temp5;
    final long yoe = temp6 / Constants.N365;
    final long yp = era * Constants.N400;
    long year = yoe + yp;
    final long doy = doe - (Constants.N365 * yoe + yoe / 4 - yoe / Constants.N100);
    final long mp = (5 * doy + 2) / Constants.N153;
    final long month;
    if (Constants.N10 > mp) {
      month = mp + Constants.N3;
    } else {
      month = mp - Constants.N9;
    }
    if (2 >= month) {
      year += 1;
    }
    return year;
  }

  /**
   * This is a class description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @return StringBuilder .
   * @author admin
   */
  public static long year(final long millis) {
    return year(millis, 0);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @param offset .
   * @return long .
   * @author admin
   */
  public static long month(final long millis, final long offset) {
    final long epochSecond = millis / 1000;
    final long localSecond = epochSecond + offset;
    final long localEpochDay = Math.floorDiv(localSecond, Constants.SECONDS_PER_DAY);
    final long zeroDay = localEpochDay + Constants.DAYS_0000_TO_1970 - 60;
    final long era;
    if (0 <= zeroDay) {
      era = zeroDay / Constants.N146097;
    } else {
      era = (zeroDay - Constants.N146096) / Constants.N146097;
    }
    final long doe = zeroDay - era * Constants.N146097;
    final long yoe = (doe - doe / Constants.N1460 + doe / Constants.N36524 - doe / Constants.N146096) / Constants.N365;
    final long doy = doe - (Constants.N365 * yoe + yoe / Constants.N4 - yoe / Constants.N100);
    final long mp = (Constants.N5 * doy + Constants.N2) / Constants.N153;
    if (Constants.N10 > mp) {
      return mp + Constants.N3;
    }
    return mp - Constants.N9;
  }

  /**
   * This is a class description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @return StringBuilder .
   * @author admin
   */
  public static long month(final long millis) {
    return month(millis, 0);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @param offset .
   * @return long .
   * @author admin
   */
  public static long day(final long millis, final long offset) {
    final long epochSecond = millis / 1000;
    final long localSecond = epochSecond + offset;
    final long localEpochDay = Math.floorDiv(localSecond, Constants.SECONDS_PER_DAY);
    final long zeroDay = localEpochDay + Constants.DAYS_0000_TO_1970 - 60;
    final long era;
    if (Constants.N0 <= zeroDay) {
      era = zeroDay / Constants.N146097;
    } else {
      era = (zeroDay - Constants.N146096) / Constants.N146097;
    }
    final long doe = zeroDay - era * Constants.N146097;
    final long yoe = (doe - doe / Constants.N1460 + doe / Constants.N36524 - doe / Constants.N146096) / Constants.N365;
    final long doy = doe - (Constants.N365 * yoe + yoe / Constants.N4 - yoe / Constants.N100);
    final long mp = (Constants.N5 * doy + Constants.N2) / Constants.N153;
    return doy - (Constants.N153 * mp + Constants.N2) / Constants.N5 + Constants.N1;
  }

  /**
   * This is a class description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @return StringBuilder .
   * @author admin
   */
  public static long day(final long millis) {
    return day(millis, 0);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @param offset .
   * @return long .
   * @author admin
   */
  public static long hours(final long millis, final long offset) {
    final long epochSecond = millis / Constants.N1000;
    final long nanoOfSecond = millis % Constants.N1000 * Constants.NANOS_PER_MILLI;
    final long localSecond = epochSecond + offset;
    final long secsOfDay = Math.floorMod(localSecond, Constants.SECONDS_PER_DAY);
    final long nanoOfDay = secsOfDay * Constants.NANOS_PER_SECOND + nanoOfSecond;
    return nanoOfDay / Constants.NANOS_PER_HOUR;
  }

  /**
   * This is a class description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @return StringBuilder .
   * @author admin
   */
  public static long hours(final long millis) {
    return hours(millis, 0);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @param offset .
   * @return long .
   * @author admin
   */
  public static long minutes(final long millis, final long offset) {
    final long epochSecond = millis / Constants.N1000;
    final long nanoOfSecond = millis % Constants.N1000 * Constants.NANOS_PER_MILLI;
    final long localSecond = epochSecond + offset;
    final long secsOfDay = Math.floorMod(localSecond, Constants.SECONDS_PER_DAY);
    long nanoOfDay = secsOfDay * Constants.NANOS_PER_SECOND + nanoOfSecond;
    final long hours = nanoOfDay / Constants.NANOS_PER_HOUR;
    nanoOfDay -= hours * Constants.NANOS_PER_HOUR;
    return nanoOfDay / Constants.NANOS_PER_MINUTE;
  }

  /**
   * This is a class description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @return StringBuilder .
   * @author admin
   */
  public static long minutes(final long millis) {
    return minutes(millis, 0);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @param offset .
   * @return long .
   * @author admin
   */
  public static long seconds(final long millis, final long offset) {
    final long epochSecond = millis / Constants.N1000;
    final long nanoOfSecond = millis % Constants.N1000 * Constants.NANOS_PER_MILLI;
    final long localSecond = epochSecond + offset;
    final long secsOfDay = Math.floorMod(localSecond, Constants.SECONDS_PER_DAY);
    long nanoOfDay = secsOfDay * Constants.NANOS_PER_SECOND + nanoOfSecond;
    final long hours = nanoOfDay / Constants.NANOS_PER_HOUR;
    nanoOfDay -= hours * Constants.NANOS_PER_HOUR;
    final long minutes = nanoOfDay / Constants.NANOS_PER_MINUTE;
    nanoOfDay -= minutes * Constants.NANOS_PER_MINUTE;
    return nanoOfDay / Constants.NANOS_PER_SECOND;
  }

  /**
   * This is a class description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @return StringBuilder .
   * @author admin
   */
  public static long seconds(final long millis) {
    return seconds(millis, 0);
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @param offset .
   * @return long .
   * @author admin
   */
  public static long millisecond(final long millis, final long offset) {
    final long epochSecond = millis / Constants.N1000;
    final long nanoOfSecond = millis % Constants.N1000 * Constants.NANOS_PER_MILLI;
    final long localSecond = epochSecond + offset;
    final long secsOfDay = Math.floorMod(localSecond, Constants.SECONDS_PER_DAY);
    long nanoOfDay = secsOfDay * Constants.NANOS_PER_SECOND + nanoOfSecond;
    final long hours = nanoOfDay / Constants.NANOS_PER_HOUR;
    nanoOfDay -= hours * Constants.NANOS_PER_HOUR;
    final long minutes = nanoOfDay / Constants.NANOS_PER_MINUTE;
    nanoOfDay -= minutes * Constants.NANOS_PER_MINUTE;
    final long seconds = nanoOfDay / Constants.NANOS_PER_SECOND;
    nanoOfDay -= seconds * Constants.NANOS_PER_SECOND;
    return nanoOfDay / Constants.NANOS_PER_MILLI;
  }

  /**
   * This is a class description.
   *
   * <p>Another description after blank line.
   *
   * @param millis .
   * @return StringBuilder .
   * @author admin
   */
  public static long millisecond(final long millis) {
    return millisecond(millis, 0);
  }
}
