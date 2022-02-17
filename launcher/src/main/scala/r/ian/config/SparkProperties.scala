package r.ian.config

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

  @BeanProperty
  var sparkConf: JavaMap[String, String] = _

  @BeanProperty
  var sparkEnv: JavaMap[String, String] = _
}
