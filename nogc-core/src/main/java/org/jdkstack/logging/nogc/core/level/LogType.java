package org.jdkstack.logging.nogc.core.level;

/**
 * .
 *
 * <p>An event log is a chronologically ordered list of the recorded events.
 * <p>In computer systems, an event log captures information about both hardware and software events.
 * <p>These event logs can be part of the operating system or specific to an application.
 * <p>Event logging provides system administrators with information useful for diagnostics and auditing.
 * <pre>
 *   Event logs:application logs ,system logs.
 *   application logs:diagnostic logs ,audit logs.
 *   system logs:diagnostic logs ,audit logs.
 * </pre>
 *
 * @author admin
 */
public enum LogType {

  DL("Diagnostic Logs", 0), AL("Audit Logs", 1);
  /** . */
  private String name;
  /** . */
  private int value;

  LogType(final String name, final int value) {
    this.name = name;
    this.value = value;
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  public String getName() {
    return this.name;
  }

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return int .
   * @author admin
   */
  public int intValue() {
    return this.value;
  }
}
