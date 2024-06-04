package org.jdkstack.logging.nogc.api.config;

/**
 * This is a method description.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public interface RecorderConfig extends ComponentConfig {

  String getState();

  void setState(String state);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getEventTypeName();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param eventTypeName .
   * @author admin
   */
  void setEventTypeName(String eventTypeName);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return int .
   * @author admin
   */
  int getEventTypeValue();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param eventTypeValue .
   * @author admin
   */
  void setEventTypeValue(int eventTypeValue);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getEventSourceId();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param eventSourceId .
   * @author admin
   */
  void setEventSourceId(String eventSourceId);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getEventSourceName();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param eventSourceName .
   * @author admin
   */
  void setEventSourceName(String eventSourceName);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getEventSourceValue();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param eventSourceValue .
   * @author admin
   */
  void setEventSourceValue(String eventSourceValue);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getHandlerProduceFilter();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param handlerProduceFilter .
   * @author admin
   */
  void setHandlerProduceFilter(String handlerProduceFilter);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getName();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param name .
   * @author admin
   */
  void setName(String name);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getMinLevel();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getMaxLevel();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getHandlers();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param handlers .
   * @author admin
   */
  void setHandlers(String handlers);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return int .
   * @author admin
   */
  int getLogTypeValue();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param logTypeValue .
   * @author admin
   */
  void setLogTypeValue(int logTypeValue);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getLogTypeName();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param logTypeName .
   * @author admin
   */
  void setLogTypeName(String logTypeName);

  int getMinLevelValue();

  void setMinLevelValue(int minLevelValue);

  int getMaxLevelValue();

  void setMaxLevelValue(int maxLevelValue);
}
