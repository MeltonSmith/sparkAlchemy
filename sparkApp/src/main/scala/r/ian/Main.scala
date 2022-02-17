package r.ian

import org.slf4j.{Logger, LoggerFactory}
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import r.ian.spark.job.Job

/**
 * Created by: mSmith
 * Date: 10.02.2022
 */
@SpringBootApplication
class Main

object Main {

  private val LOGGER: Logger = LoggerFactory.getLogger(classOf[Main])
  private val JOB_BEAN_NAME : String = "jobBeanName";
  private val params = scala.collection.mutable.Map[String, String]()

  def main(args: Array[String]): Unit = {
    val applicationContext = SpringApplication.run(classOf[Main])
    args.map(a => a.split(":"))
        .foreach(pair => params.put(pair(0),pair(1)))


    LOGGER.info("Spring active profiles:")
    val profiles = applicationContext.getEnvironment.getActiveProfiles

    if (profiles.isEmpty)
      LOGGER.info("default")
    else
      profiles.foreach(profile => LOGGER.info(profile))


    applicationContext.getBean(params(JOB_BEAN_NAME)).asInstanceOf[Job].run
  }
}
