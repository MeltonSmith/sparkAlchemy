package r.ian.config

import org.apache.spark.launcher.SparkLauncher
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}

import scala.collection.JavaConverters.mapAsScalaMapConverter

/**
 * Created by: mSmith
 * Date: 17.02.2022
 */
@Configuration
class SpringConf {

  private val LOGGER: Logger = LoggerFactory.getLogger(classOf[SpringConf])

  @Autowired
  val sparkProperties: SparkProperties = null

  @Bean
  def sparkLauncher : SparkLauncher = {
    val launcher = new SparkLauncher(sparkProperties.getSparkEnv)
      .setAppResource(sparkProperties.jarPath)
      .setMainClass("r.ian.Main")
      .setMaster(sparkProperties.master)
      .addAppArgs(sparkProperties.args)

    //additional params from yaml file for spark overriding defaults
    for ((key, value) <- sparkProperties.getSparkConf.asScala)
      launcher.setConf("spark.".concat(key), value)

    launcher.redirectToLog(LOGGER.getName)
  }

}
