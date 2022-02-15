package r.ian

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

  private val JOB_BEAN_NAME : String = "jobBeanName";
  private val params = scala.collection.mutable.Map[String, String]()

  def main(args: Array[String]): Unit = {
    val applicationContext = SpringApplication.run(classOf[Main])
    args.map(a => a.split(":"))
        .foreach(pair => params.put(pair(0),pair(1)))

    applicationContext.getBean(params.getOrElse(JOB_BEAN_NAME, "app")).asInstanceOf[Job].run
  }
}
