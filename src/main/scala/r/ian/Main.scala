package r.ian

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.context.ConfigurableApplicationContext
import r.ian.spark.job.Job

/**
 * Created by: mSmith
 * Date: 10.02.2022
 */
@SpringBootApplication
@EnableAutoConfiguration
class Main

object Main extends App {
  private val context: ConfigurableApplicationContext = SpringApplication.run(classOf[Main])

//  def main(args: Array[String]): Unit = {
//
//
//    val context = new AnnotationConfigApplicationContext(classOf[SpringConf])
//
////    context.getEnvir
//    //TODO bean by param
    context.getBean("app").asInstanceOf[Job].run
//  }
}
