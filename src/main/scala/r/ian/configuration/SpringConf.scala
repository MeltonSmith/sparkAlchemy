package r.ian.configuration

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SparkSession.Builder
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration, PropertySource}

/**
 * Created by: mSmith
 * Date: 10.02.2022
 */
@Configuration
//@ComponentScan(Array("./"))
//class SpringConf (@Autowired private val configurationProperties: ConfigurationProperties){
class SpringConf {

//  @Value("${appName}")
//  private var appName: String = _

  @Bean
  def localSparkSession() : SparkSession = {
     SparkSession.builder()
//       .appName(configurationProperties.appName)
       .appName("1233")
       .master("spark://EPRUPETW09AA:7077")
//       .config("deploy-mode", "client")
       .getOrCreate
  }
}
