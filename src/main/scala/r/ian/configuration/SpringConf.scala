package r.ian.configuration

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SparkSession.Builder
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration, PropertySource}
import org.springframework.core.env.Environment

/**
 * Created by: mSmith
 * Date: 10.02.2022
 */
@Configuration
class SpringConf {

  @Autowired
  var env: Environment = _

  @Bean
  def sparkSession() : SparkSession = {
     SparkSession.builder()
       .appName(env.getProperty("app.name"))
       .master(env.getProperty("app.masterLocation"))
       .getOrCreate
  }
}
