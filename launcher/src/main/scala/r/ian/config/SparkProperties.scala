package r.ian.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

import java.util.{Map => JavaMap}
import scala.beans.BeanProperty

/**
 * A bean responsible for parsing from yaml files
 *
 * Created by: mSmith
 * Date: 17.02.2022
 */
@Component
@ConfigurationProperties
class SparkProperties {

  /**
   * Spark params
   */
  @BeanProperty
  var sparkConf: JavaMap[String, String] = _

  /**
   * Environment for spark
   */
  @BeanProperty
  var sparkEnv: JavaMap[String, String] = _

  /**
   * Args for submit command.
   */
  @Value("${submitConf.args}")
  val args: String = null

  /**
   * A jar with job to execute
   */
  @Value("${submitConf.jarPath}")
  val jarPath: String = null

  /**
   * Master URL
   */
  @Value("${submitConf.master}")
  val master: String = null
}
