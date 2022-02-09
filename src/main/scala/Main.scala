import configuration.SpringConf
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * Created by: mSmith
 * Date: 10.02.2022
 */
object Main {
  def main(args: Array[String]): Unit = {
    val context = new AnnotationConfigApplicationContext(classOf[SpringConf])

    context.getBean("app").asInstanceOf[sparkJobs.job.App].run();
  }
}
