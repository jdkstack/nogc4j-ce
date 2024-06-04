package org.jdkstack.logging.nogc.core.config;

import org.jdkstack.logging.nogc.api.config.ContextConfiguration;
import org.jdkstack.logging.nogc.core.datetime.TimeZone;

/**
 * System configuration,Configuration shared by all components.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public class LogComponentContextConfiguration implements ContextConfiguration {

  /** The capacity of the ring buffer. */
  private int ringBufferSize = 4096;
  /** mmap region length ,default 1GB. */
  private long regionLength = 104857600;
  /** The consumer thread of the ring buffer. */
  private int consumers = 1;
  /** Current runtime application software process id. */
  private long pid = 0L;
  /** Current runtime system software time zone. */
  private long timeZone = TimeZone.EAST8;
  /** Current runtime system software host name. */
  private String hostName = "-";
  /** Current runtime system software host ip. */
  private String hostIp = "-";
  /** Current runtime application software id. */
  private String applicationSoftwareId = "-";
  /** Current runtime application software version. */
  private String applicationSoftwareVersion = "-";
  /** Current runtime application software name. */
  private String applicationSoftwareName = "-";
  /** Current runtime system software information, for example 22635.3500. */
  private String systemSoftwareId = "-";
  /** for example 23H2. */
  private String systemSoftwareVersion = "-";
  /** for example Windows 11. */
  private String systemSoftwareName = "-";
  /** Current runtime hardware information. */
  private String hardwareId = "-";
  /** R6615/14. */
  private String hardwareVersion = "-";
  /** . */
  private String hardwareName = "-";

  @Override
  public int getRingBufferSize() {
    return this.ringBufferSize;
  }

  @Override
  public void setRingBufferSize(final int ringBufferSize) {
    this.ringBufferSize = ringBufferSize;
  }

  @Override
  public int getConsumers() {
    return this.consumers;
  }

  @Override
  public void setConsumers(final int consumers) {
    this.consumers = consumers;
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
  public long getPid() {
    return this.pid;
  }

  @Override
  public void setPid(final long pid) {
    this.pid = pid;
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
  public long getRegionLength() {
    return this.regionLength;
  }

  @Override
  public void setRegionLength(final long regionLength) {
    this.regionLength = regionLength;
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
  public String getApplicationSoftwareName() {
    return this.applicationSoftwareName;
  }

  @Override
  public void setApplicationSoftwareName(final String applicationSoftwareName) {
    this.applicationSoftwareName = applicationSoftwareName;
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
}
