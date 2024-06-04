package org.jdkstack.logging.nogc.api.record;

/**
 * This is a class description.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public interface Record {

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return StringBuilder[]  .
   * @author admin
   */
  StringBuilder[] getSegments();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param params .
   * @param index  .
   * @author admin
   */
  void setSegments(StringBuilder params, int index);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return StringBuilder  .
   * @author admin
   */
  StringBuilder getDateTime();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getHostIp();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param hostIp .
   * @author admin
   */
  void setHostIp(String hostIp);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getEventTypeName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param eventTypeName .
   * @author admin
   */
  void setEventTypeName(String eventTypeName);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return int  .
   * @author admin
   */
  int getEventTypeValue();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param eventTypeValue .
   * @author admin
   */
  void setEventTypeValue(int eventTypeValue);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getEventSourceId();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param eventSourceId .
   * @author admin
   */
  void setEventSourceId(String eventSourceId);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getEventSourceName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param eventSourceName .
   * @author admin
   */
  void setEventSourceName(String eventSourceName);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getEventSourceValue();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param eventSourceValue .
   * @author admin
   */
  void setEventSourceValue(String eventSourceValue);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getApplicationSoftwareId();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param applicationSoftwareId .
   * @author admin
   */
  void setApplicationSoftwareId(String applicationSoftwareId);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getApplicationSoftwareVersion();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param applicationSoftwareVersion .
   * @author admin
   */
  void setApplicationSoftwareVersion(String applicationSoftwareVersion);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getSystemSoftwareId();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param systemSoftwareId .
   * @author admin
   */
  void setSystemSoftwareId(String systemSoftwareId);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getSystemSoftwareVersion();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param systemSoftwareVersion .
   * @author admin
   */
  void setSystemSoftwareVersion(String systemSoftwareVersion);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getSystemSoftwareName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param systemSoftwareName .
   * @author admin
   */
  void setSystemSoftwareName(String systemSoftwareName);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getHardwareId();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param hardwareId .
   * @author admin
   */
  void setHardwareId(String hardwareId);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getHardwareVersion();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param hardwareVersion .
   * @author admin
   */
  void setHardwareVersion(String hardwareVersion);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getHardwareName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param hardwareName .
   * @author admin
   */
  void setHardwareName(String hardwareName);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return int  .
   * @author admin
   */
  int getLevelValue();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param levelValue .
   * @author admin
   */
  void setLevelValue(int levelValue);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  Object[] getParams();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logLevel .
   * @author admin
   */
  void setLevelName(String logLevel);

  void setParams(Object params, int index);

  int[] getPaths();

  void setPaths(int path, int index);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param thrown .
   * @author admin
   */
  void setThrown(Throwable thrown);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String 日志级别名称.
   * @author admin
   */
  String getLevelName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return Throwable  .
   * @author admin
   */
  Throwable getThrowable();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param throwable .
   * @author admin
   */
  void setThrowable(Throwable throwable);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return StringBuilder  .
   * @author admin
   */
  StringBuilder getMessageText();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param message .
   * @author admin
   */
  void setMessageText(String message);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @author admin
   */
  void clear();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param name .
   * @author admin
   */
  void setName(String name);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getProducerThreadName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param producerThreadName .
   * @author admin
   */
  void setProducerThreadName(String producerThreadName);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return long  .
   * @author admin
   */
  long getProducerThreadValue();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param producerThreadValue .
   * @author admin
   */
  void setProducerThreadValue(long producerThreadValue);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getConsumerThreadName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param consumerThreadName .
   * @author admin
   */
  void setConsumerThreadName(String consumerThreadName);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return int  .
   * @author admin
   */
  int getConsumerThreadValue();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param consumerThreadValue .
   * @author admin
   */
  void setConsumerThreadValue(int consumerThreadValue);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getLogTypeName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logTypeName .
   * @author admin
   */
  void setLogTypeName(String logTypeName);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return int  .
   * @author admin
   */
  int getLogTypeValue();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param logTypeValue .
   * @author admin
   */
  void setLogTypeValue(int logTypeValue);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getHostName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param hostName .
   * @author admin
   */
  void setHostName(String hostName);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getApplicationSoftwareName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param applicationSoftwareName .
   * @author admin
   */
  void setApplicationSoftwareName(String applicationSoftwareName);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return long  .
   * @author admin
   */
  long getProcessId();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param processId .
   * @author admin
   */
  void setProcessId(long processId);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return long  .
   * @author admin
   */
  long getTimeZone();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param timeZone .
   * @author admin
   */
  void setTimeZone(long timeZone);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getClassName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param className .
   * @author admin
   */
  void setClassName(String className);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getMethodName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param methodName .
   * @author admin
   */
  void setMethodName(String methodName);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return int  .
   * @author admin
   */
  int getLineNumber();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param lineNumber .
   * @author admin
   */
  void setLineNumber(int lineNumber);

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @return String  .
   * @author admin
   */
  String getFileName();

  /**
   * This is a method description.
   *
   * <p>Another description after blank line.
   *
   * @param fileName .
   * @author admin
   */
  void setFileName(String fileName);

  long getYear();

  void setYear(long year);

  long getMonth();

  void setMonth(long month);

  long getDay();

  void setDay(long day);

  long getHours();

  void setHours(long hours);

  long getMinutes();

  void setMinutes(long minutes);

  long getSeconds();

  void setSeconds(long seconds);
}
