package org.jdkstack.logging.nogc.core.thread.utils;

public class LongCache {

  public static final Long[] cache = new Long[65535];

  static {
    for (int i = 0; i < cache.length; i++) {
      cache[i] = new Long(i);
    }
  }

  private LongCache() {
    //
  }
}
