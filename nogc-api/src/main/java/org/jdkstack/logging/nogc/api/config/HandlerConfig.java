package org.jdkstack.logging.nogc.api.config;

/**
 * This is a method description.
 *
 * <p>Another description after blank line.
 *
 * @author admin
 */
public interface HandlerConfig extends ComponentConfig {

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getFileNameExt();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param fileNameExt .
   * @author admin
   */
  void setFileNameExt(String fileNameExt);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getFileName();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param fileName .
   * @author admin
   */
  void setFileName(String fileName);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getHandlerConsumeFilter();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param handlerConsumeFilter .
   * @author admin
   */
  void setHandlerConsumeFilter(String handlerConsumeFilter);

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
  String getDirectory();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getPrefix();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param prefix .
   * @author admin
   */
  void setPrefix(String prefix);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getEncoding();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getType();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getFormatter();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return int .
   * @author admin
   */
  int getCapacity();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param capacity .
   * @author admin
   */
  void setCapacity(int capacity);

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @return String .
   * @author admin
   */
  String getMode();

  /**
   * Configure interfaces.
   *
   * <p>Another description after blank line.
   *
   * @param mode .
   * @author admin
   */
  void setMode(String mode);

  int getBatchSize();

  void setBatchSize(int batchSize);

  String getPolicy();

  void setPolicy(String policy);

  boolean isAppend();

  void setAppend(boolean append);
}
