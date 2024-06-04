package org.jdkstack.logging.nogc.core.datetime;

/**
 * This is a class description.
 *
 * <p>.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public final class Constants {

  /** . */
  public static final int HOURS_PER_DAY = 24;
  /** . */
  public static final int MINUTES_PER_HOUR = 60;
  /** . */
  public static final int SECONDS_PER_MINUTE = 60;
  /** . */
  public static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
  /** . */
  public static final int SECONDS_PER_DAY = SECONDS_PER_HOUR * HOURS_PER_DAY;
  /** . */
  public static final long MILLS_PER_SECOND = 1000L;
  /** . */
  public static final long MICROS_PER_SECOND = MILLS_PER_SECOND * 1000L;
  /** . */
  public static final long MICROS_PER_MILLI = 1000L;
  /** . */
  public static final long NANOS_PER_MILLI = MILLS_PER_SECOND * 1000L;
  /** . */
  public static final long NANOS_PER_SECOND = 1000 * NANOS_PER_MILLI;
  /** . */
  public static final long NANOS_PER_MINUTE = NANOS_PER_SECOND * SECONDS_PER_MINUTE;
  /** . */
  public static final long NANOS_PER_HOUR = NANOS_PER_MINUTE * MINUTES_PER_HOUR;
  /** . */
  public static final long NANOS_PER_DAY = NANOS_PER_HOUR * HOURS_PER_DAY;
  /** 365. */
  public static final long DAY = 365L;
  /** . */
  public static final long CYCLE = 400L;
  /** . */
  public static final long LEAP = 97L;
  /** . */
  public static final long DAYS_PER_CYCLE1 = CYCLE * DAY;
  /** . */
  public static final long DAYS_PER_CYCLE = DAYS_PER_CYCLE1 + LEAP;
  /** . */
  public static final long DAYS_0000_TO_2000 = DAYS_PER_CYCLE * 5L;
  /** . */
  public static final long N146097 = DAYS_PER_CYCLE;
  /** . */
  public static final long N146096 = DAYS_PER_CYCLE - 1;
  /** . */
  public static final long DAYS_30 = 30L * DAY;
  /** . */
  public static final long DAYS_1970_TO_2000 = DAYS_30 + 7L;
  /** . */
  public static final long DAYS_0000_TO_1970 = DAYS_0000_TO_2000 - DAYS_1970_TO_2000;
  /** . */
  public static final long DAYS_0000_TO_1970_MARCH_ONE = DAYS_0000_TO_1970 - 60;
  /** . */
  public static final int N0 = 0;
  /** . */
  public static final int N1 = 1;
  /** . */
  public static final int N2 = 2;
  /** . */
  public static final int N3 = 3;
  /** . */
  public static final int N4 = 4;
  /** . */
  public static final int N5 = 5;
  /** . */
  public static final int N6 = 6;
  /** . */
  public static final int N7 = 7;
  /** . */
  public static final int N8 = 8;
  /** . */
  public static final int N9 = 9;
  /** . */
  public static final int N10 = 10;
  /** . */
  public static final int N11 = 11;
  /** . */
  public static final int N12 = 12;
  /** . */
  public static final int N13 = 13;
  /** . */
  public static final int N14 = 14;
  /** . */
  public static final int N15 = 15;
  /** . */
  public static final int N16 = 16;
  /** . */
  public static final int N17 = 17;
  /** . */
  public static final int N18 = 18;
  /** . */
  public static final int N19 = 19;
  /** . */
  public static final int N20 = 20;
  /** . */
  public static final int N21 = 21;
  /** . */
  public static final int N22 = 22;
  /** . */
  public static final int N23 = 23;
  /** . */
  public static final int N28 = 28;
  /** . */
  public static final int N24 = 24;
  /** . */
  public static final int N100 = 100;
  /** . */
  public static final int N153 = 153;
  /** . */
  public static final int N256 = 256;
  /** . */
  public static final int N365 = 365;
  /** . */
  public static final int N399 = 399;
  /** . */
  public static final int N400 = 400;
  /** . */
  public static final int N60 = 60;
  /** . */
  public static final int N1000 = 1000;
  /** . */
  public static final int N1460 = 1460;
  /** . */
  public static final int N36524 = 36524;
  /** . */
  public static final int N9999 = 9999;
  /** . */
  public static final int N10000 = 10000;

  private Constants() {
    //
  }
}
