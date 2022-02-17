package r.ian.configuration

import org.apache.spark.launcher.SparkLauncher
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SparkSession.Builder
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration, DependsOn, Profile, PropertySource}
import org.springframework.core.env.Environment

/**
 * Created by: mSmith
 * Date: 10.02.2022
 */
@Configuration
class SpringConf {

  @Autowired
  var env: Environment = _

  /**
   * For default profile - runs local mode
   * @return
   */
  @Bean
  @Profile(Array("default"))
  def localSparkSessionBuilder() : SparkSession.Builder = {
     SparkSession.builder()
//       .appName(env.getProperty("app.name"))
       .master(env.getProperty("app.masterLocation"))
//       .getOrCreate
  }

  /**
   * Standalone mode
   * Params should be taken from spark submit
   * @return
   */
  @Bean
  @Profile(Array("standalone"))
  def sparkSessionBuilder() : SparkSession.Builder = {
    SparkSession.builder()
//      .appName(env.getProperty("app.name"))
//      .getOrCreate
  }

}
