package r.ian.config

import org.apache.spark.launcher.SparkLauncher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}

import scala.collection.JavaConverters.mapAsScalaMapConverter

/**
 * Created by: mSmith
 * Date: 17.02.2022
 */
@Configuration
class SpringConf {

  @Autowired
  var sparkProperties: SparkProperties = _

  @Bean
  def sparkLauncher : SparkLauncher = {
    val launcher = new SparkLauncher(sparkProperties.getSparkEnv)
      .setAppResource("/Users/Ian_Rakhmatullin/IdeaProjects/sparkAlchemy/sparkApp/build/libs/sparkApp-1.0-SNAPSHOT-all.jar")
      .setMainClass("r.ian.Main")
      .setMaster("spark://EPRUPETW09AA:7077")
      .setConf(SparkLauncher.DEPLOY_MODE, "cluster")
      .addAppArgs("jobBeanName:app")

    //additional params from yaml file
    for ((key, value) <- sparkProperties.getSparkConf.asScala)
      launcher.setConf("spark.".concat(key), value)

    launcher
  }

}
