package org.jdkstack.logging.nogc.api.config;

/**
 * This is a method description.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public interface ContextConfiguration {

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return int .
   * @author admin
   */
  int getRingBufferSize();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param ringBufferSize .
   * @author admin
   */
  void setRingBufferSize(int ringBufferSize);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return int .
   * @author admin
   */
  int getConsumers();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param consumers .
   * @author admin
   */
  void setConsumers(int consumers);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getHostName();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param hostName .
   * @author admin
   */
  void setHostName(String hostName);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return long .
   * @author admin
   */
  long getPid();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param pid .
   * @author admin
   */
  void setPid(long pid);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return long .
   * @author admin
   */
  long getTimeZone();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param timeZone .
   * @author admin
   */
  void setTimeZone(long timeZone);

  long getRegionLength();

  void setRegionLength(long regionLength);

  String getHostIp();

  void setHostIp(String hostIp);

  String getApplicationSoftwareId();

  void setApplicationSoftwareId(String applicationSoftwareId);

  String getApplicationSoftwareVersion();

  void setApplicationSoftwareVersion(String applicationSoftwareVersion);

  String getApplicationSoftwareName();

  void setApplicationSoftwareName(String applicationSoftwareName);

  String getSystemSoftwareId();

  void setSystemSoftwareId(String systemSoftwareId);

  String getSystemSoftwareVersion();

  void setSystemSoftwareVersion(String systemSoftwareVersion);

  String getSystemSoftwareName();

  void setSystemSoftwareName(String systemSoftwareName);

  String getHardwareId();

  void setHardwareId(String hardwareId);

  String getHardwareVersion();

  void setHardwareVersion(String hardwareVersion);

  String getHardwareName();

  void setHardwareName(String hardwareName);
}
