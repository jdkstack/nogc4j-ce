package org.jdkstack.logging.nogc.core.config;

import java.util.concurrent.atomic.AtomicReference;
import org.jdkstack.logging.nogc.api.config.RecorderConfig;
import org.jdkstack.logging.nogc.core.Constants;
import org.jdkstack.logging.nogc.core.level.EventType;
import org.jdkstack.logging.nogc.core.level.LogType;

/**
 * Each recorder has its own configuration.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public class LogRecorderConfig implements RecorderConfig {

  /** Each recorder has its own min log level. */
  private String minLevel = "MIN";
  /** Each recorder has its own max log level. */
  private String maxLevel = "MAX";
  /** Each recorder has its own min log level. */
  private int minLevelValue = -10000;
  /** Each recorder has its own max log level. */
  private int maxLevelValue = 10000;
  /** Each recorder has its own name, default value is default. */
  private String name = Constants.DEFAULT;
  /** Each recorder has its own handler, default value is default. */
  private String handlers = Constants.DEFAULT;
  /** Each recorder has its own filter, default value is handlerProduceFilter. */
  private String handlerProduceFilter = "handlerProduceFilter";
  /** diagnostic logs/audit logs. */
  private String logTypeName = LogType.DL.getName();
  /** 0/1. */
  private int logTypeValue = LogType.DL.intValue();
  /** Application Software events/System Software events. */
  private String eventTypeName = EventType.APE.getName();
  /** 0/1. */
  private int eventTypeValue = EventType.APE.intValue();
  /** Which module of the event source software. */
  private String eventSourceId = "-";
  /** . */
  private String eventSourceName = "-";
  /** . */
  private String eventSourceValue = "-";
  /** Recorder is synchronous or asynchronous,default asynchronous. */
  private AtomicReference<String> state = new AtomicReference<>("asynchronous");

  @Override
  public String getState() {
    return this.state.get();
  }

  @Override
  public void setState(final String state) {
    this.state.set(state);
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
  public String getHandlerProduceFilter() {
    return this.handlerProduceFilter;
  }

  @Override
  public void setHandlerProduceFilter(final String handlerProduceFilter) {
    this.handlerProduceFilter = handlerProduceFilter;
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
  public String getMinLevel() {
    return this.minLevel;
  }

  @Override
  public String getMaxLevel() {
    return this.maxLevel;
  }

  @Override
  public String getHandlers() {
    return this.handlers;
  }

  @Override
  public void setHandlers(final String handlers) {
    this.handlers = handlers;
  }

  @Override
  public int getLogTypeValue() {
    return logTypeValue;
  }

  @Override
  public void setLogTypeValue(final int logTypeValue) {
    this.logTypeValue = logTypeValue;
  }

  @Override
  public String getLogTypeName() {
    return logTypeName;
  }

  @Override
  public void setLogTypeName(final String logTypeName) {
    this.logTypeName = logTypeName;
  }

  @Override
  public int getMinLevelValue() {
    return this.minLevelValue;
  }

  @Override
  public void setMinLevelValue(final int minLevelValue) {
    this.minLevelValue = minLevelValue;
  }

  @Override
  public int getMaxLevelValue() {
    return this.maxLevelValue;
  }

  @Override
  public void setMaxLevelValue(final int maxLevelValue) {
    this.maxLevelValue = maxLevelValue;
  }
}
