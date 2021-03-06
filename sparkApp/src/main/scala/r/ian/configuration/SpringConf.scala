package r.ian.configuration

import org.apache.spark.sql.SparkSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration, Profile}
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
   * @return sparkSessionBuilder for local mode
   */
  @Bean
  @Profile(Array("default"))
  def localSparkSessionBuilder() : SparkSession.Builder = {
     SparkSession.builder()
       //FIXME
       .master(env.getProperty("app.masterLocation"))
  }

  /**
   * Others nonLocal mode
   * Params should be taken from spark submit, here, they do not take any effect
   * @return sparkSessionBuilder
   */
  @Bean
  @Profile(Array("nonLocal"))
  def sparkSessionBuilder() : SparkSession.Builder = {
      SparkSession.builder()
  }

}
