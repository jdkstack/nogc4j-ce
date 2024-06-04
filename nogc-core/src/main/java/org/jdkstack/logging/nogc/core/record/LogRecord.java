package org.jdkstack.logging.nogc.core.record;

import java.util.Arrays;
import org.jdkstack.logging.nogc.api.record.Record;

/**
 * .
 *
 * <p>.
 *
 * @author admin
 */
public class LogRecord implements Record {

  /** . */
  private final StringBuilder messageText = new StringBuilder(1024);
  /** . */
  private final StringBuilder datetime = new StringBuilder(100);
  /** . */
  private final Object[] params = new Object[9];
  /** . */
  private final int[] paths = new int[9];
  /** . */
  private final StringBuilder[] segments = new StringBuilder[9];
  /** . */
  private String name;
  /** . */
  private String className = "-";
  /** . */
  private String methodName = "-";
  /** . */
  private int lineNumber = 0;
  /** . */
  private String fileName = "-";
  /** . */
  private String levelName;
  /** . */
  private int levelValue;
  /** . */
  private String producerThreadName;
  /** . */
  private long producerThreadValue;
  /** . */
  private String consumerThreadName;
  /** . */
  private int consumerThreadValue;
  /** . */
  private Throwable throwable;
  /** diagnostic logs/audit logs . */
  private String logTypeName;
  /** . */
  private int logTypeValue;
  /** . */
  private String hostName = "-";
  /** . */
  private String hostIp = "-";
  /** . */
  private long processId;
  /** . */
  private long timeZone;
  /** Application Software events/System Software events. */
  private String eventTypeName;
  /** . */
  private int eventTypeValue;
  /** . */
  private String eventSourceId = "-";
  /** . */
  private String eventSourceName = "-";
  /** . */
  private String eventSourceValue = "-";
  /** . */
  private String applicationSoftwareId = "-";
  /** . */
  private String applicationSoftwareVersion = "-";
  /** . */
  private String applicationSoftwareName = "-";
  /** windows/android/linux/Xiaomi HyperOS. */
  private String systemSoftwareId = "-";
  /** . */
  private String systemSoftwareVersion = "-";
  /** . */
  private String systemSoftwareName = "-";
  /** . */
  private String hardwareId = "-";
  /** R6615/14. */
  private String hardwareVersion = "-";
  /** . */
  private String hardwareName = "-";
  /** . */
  private long year;
  /** . */
  private long month;
  /** . */
  private long day;
  /** . */
  private long hours;
  /** . */
  private long minutes;
  /** . */
  private long seconds;

  public LogRecord() {
    //
  }

  @Override
  public StringBuilder[] getSegments() {
    return this.segments;
  }

  @Override
  public void setSegments(final StringBuilder params, final int index) {
    this.segments[index] = params;
  }

  @Override
  public StringBuilder getDateTime() {
    return this.datetime;
  }

  @Override
  public void setThrowable(final Throwable throwable) {
    this.throwable = throwable;
  }

  @Override
  public String getHostIp() {
    return this.hostIp;
  }

  @Override
  public void setHostIp(final String hostIp) {
    this.hostIp = hostIp;
  }

  @Override
  public String getEventTypeName() {
    return this.eventTypeName;
  }

  @Override
  public void setEventTypeName(final String eventTypeName) {
    this.eventTypeName = eventTypeName;
  }

  @Override
  public int getEventTypeValue() {
    return this.eventTypeValue;
  }

  @Override
  public void setEventTypeValue(final int eventTypeValue) {
    this.eventTypeValue = eventTypeValue;
  }

  @Override
  public String getEventSourceId() {
    return this.eventSourceId;
  }

  @Override
  public void setEventSourceId(final String eventSourceId) {
    this.eventSourceId = eventSourceId;
  }

  @Override
  public String getEventSourceName() {
    return this.eventSourceName;
  }

  @Override
  public void setEventSourceName(final String eventSourceName) {
    this.eventSourceName = eventSourceName;
  }

  @Override
  public String getEventSourceValue() {
    return this.eventSourceValue;
  }

  @Override
  public void setEventSourceValue(final String eventSourceValue) {
    this.eventSourceValue = eventSourceValue;
  }

  @Override
  public String getApplicationSoftwareId() {
    return this.applicationSoftwareId;
  }

  @Override
  public void setApplicationSoftwareId(final String applicationSoftwareId) {
    this.applicationSoftwareId = applicationSoftwareId;
  }

  @Override
  public String getApplicationSoftwareVersion() {
    return this.applicationSoftwareVersion;
  }

  @Override
  public void setApplicationSoftwareVersion(final String applicationSoftwareVersion) {
    this.applicationSoftwareVersion = applicationSoftwareVersion;
  }

  @Override
  public String getSystemSoftwareId() {
    return this.systemSoftwareId;
  }

  @Override
  public void setSystemSoftwareId(final String systemSoftwareId) {
    this.systemSoftwareId = systemSoftwareId;
  }

  @Override
  public String getSystemSoftwareVersion() {
    return this.systemSoftwareVersion;
  }

  @Override
  public void setSystemSoftwareVersion(final String systemSoftwareVersion) {
    this.systemSoftwareVersion = systemSoftwareVersion;
  }

  @Override
  public String getSystemSoftwareName() {
    return this.systemSoftwareName;
  }

  @Override
  public void setSystemSoftwareName(final String systemSoftwareName) {
    this.systemSoftwareName = systemSoftwareName;
  }

  @Override
  public String getHardwareId() {
    return this.hardwareId;
  }

  @Override
  public void setHardwareId(final String hardwareId) {
    this.hardwareId = hardwareId;
  }

  @Override
  public String getHardwareVersion() {
    return this.hardwareVersion;
  }

  @Override
  public void setHardwareVersion(final String hardwareVersion) {
    this.hardwareVersion = hardwareVersion;
  }

  @Override
  public String getHardwareName() {
    return this.hardwareName;
  }

  @Override
  public void setHardwareName(final String hardwareName) {
    this.hardwareName = hardwareName;
  }

  @Override
  public int getLevelValue() {
    return this.levelValue;
  }

  @Override
  public void setLevelValue(final int levelValue) {
    this.levelValue = levelValue;
  }

  @Override
  public Object[] getParams() {
    return this.params;
  }

  @Override
  public void setParams(final Object params, final int index) {
    this.params[index] = params;
  }

  @Override
  public int[] getPaths() {
    return this.paths;
  }

  @Override
  public void setPaths(final int path, final int index) {
    this.paths[index] = path;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public void setThrown(final Throwable thrown) {
    this.throwable = thrown;
  }

  @Override
  public String getLevelName() {
    return this.levelName;
  }

  @Override
  public void setLevelName(final String logLevel) {
    this.levelName = logLevel;
  }

  @Override
  public Throwable getThrowable() {
    return this.throwable;
  }

  @Override
  public StringBuilder getMessageText() {
    return this.messageText;
  }

  @Override
  public void setMessageText(String message) {
    this.messageText.append(message);
  }

  @Override
  public void clear() {
    this.levelName = null;
    this.levelValue = 0;
    this.name = null;
    this.messageText.setLength(0);
    this.datetime.setLength(0);
    this.throwable = null;
    Arrays.fill(this.params, null);
    Arrays.fill(this.paths, 0);
    this.producerThreadName = null;
    this.producerThreadValue = 0;
    this.consumerThreadName = null;
    this.consumerThreadValue = 0;
  }

  @Override
  public String getProducerThreadName() {
    return this.producerThreadName;
  }

  @Override
  public void setProducerThreadName(final String producerThreadName) {
    this.producerThreadName = producerThreadName;
  }

  @Override
  public long getProducerThreadValue() {
    return this.producerThreadValue;
  }

  @Override
  public void setProducerThreadValue(final long producerThreadValue) {
    this.producerThreadValue = producerThreadValue;
  }

  @Override
  public String getConsumerThreadName() {
    return this.consumerThreadName;
  }

  @Override
  public void setConsumerThreadName(final String consumerThreadName) {
    this.consumerThreadName = consumerThreadName;
  }

  @Override
  public int getConsumerThreadValue() {
    return this.consumerThreadValue;
  }

  @Override
  public void setConsumerThreadValue(final int consumerThreadValue) {
    this.consumerThreadValue = consumerThreadValue;
  }

  @Override
  public String getLogTypeName() {
    return this.logTypeName;
  }

  @Override
  public void setLogTypeName(final String logTypeName) {
    this.logTypeName = logTypeName;
  }

  @Override
  public int getLogTypeValue() {
    return this.logTypeValue;
  }

  @Override
  public void setLogTypeValue(final int logTypeValue) {
    this.logTypeValue = logTypeValue;
  }

  @Override
  public String getHostName() {
    return this.hostName;
  }

  @Override
  public void setHostName(final String hostName) {
    this.hostName = hostName;
  }

  @Override
  public String getApplicationSoftwareName() {
    return this.applicationSoftwareName;
  }

  @Override
  public void setApplicationSoftwareName(final String applicationName) {
    this.applicationSoftwareName = applicationName;
  }

  @Override
  public long getProcessId() {
    return this.processId;
  }

  @Override
  public void setProcessId(final long processId) {
    this.processId = processId;
  }

  @Override
  public long getTimeZone() {
    return this.timeZone;
  }

  @Override
  public void setTimeZone(final long timeZone) {
    this.timeZone = timeZone;
  }

  @Override
  public String getClassName() {
    return this.className;
  }

  @Override
  public void setClassName(final String className) {
    this.className = className;
  }

  @Override
  public String getMethodName() {
    return this.methodName;
  }

  @Override
  public void setMethodName(final String methodName) {
    this.methodName = methodName;
  }

  @Override
  public int getLineNumber() {
    return this.lineNumber;
  }

  @Override
  public void setLineNumber(final int lineNumber) {
    this.lineNumber = lineNumber;
  }

  @Override
  public String getFileName() {
    return this.fileName;
  }

  @Override
  public void setFileName(final String fileName) {
    this.fileName = fileName;
  }

  @Override
  public long getYear() {
    return this.year;
  }

  @Override
  public void setYear(final long year) {
    this.year = year;
  }

  @Override
  public long getMonth() {
    return this.month;
  }

  @Override
  public void setMonth(final long month) {
    this.month = month;
  }

  @Override
  public long getDay() {
    return this.day;
  }

  @Override
  public void setDay(final long day) {
    this.day = day;
  }

  @Override
  public long getHours() {
    return this.hours;
  }

  @Override
  public void setHours(final long hours) {
    this.hours = hours;
  }

  @Override
  public long getMinutes() {
    return this.minutes;
  }

  @Override
  public void setMinutes(final long minutes) {
    this.minutes = minutes;
  }

  @Override
  public long getSeconds() {
    return this.seconds;
  }

  @Override
  public void setSeconds(final long seconds) {
    this.seconds = seconds;
  }
}
