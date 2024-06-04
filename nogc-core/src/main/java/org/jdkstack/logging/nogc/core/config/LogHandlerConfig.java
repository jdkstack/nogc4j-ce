package org.jdkstack.logging.nogc.core.config;

import org.jdkstack.logging.nogc.api.config.HandlerConfig;
import org.jdkstack.logging.nogc.core.Constants;

/**
 * .
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public class LogHandlerConfig implements HandlerConfig {

  /** . */
  private final String directory = "logs";
  /** . */
  private final String encoding = "UTF-8";
  /** . */
  private final String type = "size";
  /** . */
  private final String formatter = "logJsonFormatter";
  /** . */
  private String prefix = Constants.DEFAULT;
  /** . */
  private String name = Constants.DEFAULT;
  /** . */
  private String fileName = Constants.DEFAULT;
  /** . */
  private int capacity = 16;
  /** . */
  private String mode = "rw";
  /** . */
  private String fileNameExt = ".log";
  /** . */
  private String handlerConsumeFilter = "handlerConsumeFilter";
  /** . */
  private int batchSize = 1;
  /** . */
  private String policy = "lineBasedTriggeringPolicy";

  private boolean append;

  @Override
  public String getFileNameExt() {
    return this.fileNameExt;
  }

  @Override
  public void setFileNameExt(final String fileNameExt) {
    this.fileNameExt = fileNameExt;
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
  public String getHandlerConsumeFilter() {
    return this.handlerConsumeFilter;
  }

  @Override
  public void setHandlerConsumeFilter(final String handlerConsumeFilter) {
    this.handlerConsumeFilter = handlerConsumeFilter;
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
  public String getDirectory() {
    return this.directory;
  }

  @Override
  public String getPrefix() {
    return this.prefix;
  }

  @Override
  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  @Override
  public String getEncoding() {
    return this.encoding;
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  public String getFormatter() {
    return this.formatter;
  }

  @Override
  public int getCapacity() {
    return this.capacity;
  }

  @Override
  public void setCapacity(final int capacity) {
    this.capacity = capacity;
  }

  @Override
  public String getMode() {
    return this.mode;
  }

  @Override
  public void setMode(final String mode) {
    this.mode = mode;
  }

  @Override
  public int getBatchSize() {
    return this.batchSize;
  }

  @Override
  public void setBatchSize(final int batchSize) {
    this.batchSize = batchSize;
  }

  @Override
  public String getPolicy() {
    return this.policy;
  }

  @Override
  public void setPolicy(final String policy) {
    this.policy = policy;
  }

  @Override
  public boolean isAppend() {
    return this.append;
  }

  @Override
  public void setAppend(final boolean append) {
    this.append = append;
  }
}
