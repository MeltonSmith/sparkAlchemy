package r.ian

import org.apache.spark.launcher.SparkLauncher
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by: mSmith
 * Date: 15.02.2022
 */
@SpringBootApplication
class LauncherMain

object LauncherMain {

    private val LOGGER: Logger = LoggerFactory.getLogger(classOf[LauncherMain])

    def main(args: Array[String]): Unit = {
        val applicationContext = SpringApplication.run(classOf[LauncherMain])

        val launcher = applicationContext.getBean("sparkLauncher").asInstanceOf[SparkLauncher]

        val sparkProcess = launcher.launch

        sparkProcess.waitFor()
    }

}
