package org.jdkstack.logging.nogc.core.level;

import org.jdkstack.logging.nogc.api.level.Level;

/**
 * .
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public class LogLevel implements Level {

  /** . */
  private String name;
  /** . */
  private int value;

  public LogLevel(final String name, final int value) {
    this.name = name;
    this.value = value;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int intValue() {
    return this.value;
  }
}
