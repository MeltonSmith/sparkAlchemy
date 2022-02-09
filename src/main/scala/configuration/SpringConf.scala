package configuration

import org.apache.spark.sql.SparkSession
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}

/**
 * Created by: mSmith
 * Date: 10.02.2022
 */
@Configuration
@ComponentScan(Array("./"))
class SpringConf {

  @Bean
  def localSparkSession() : SparkSession = {
     SparkSession.builder()
       .appName("testAppLocal")
       .master("local[*]")
       .getOrCreate()
  }
}
