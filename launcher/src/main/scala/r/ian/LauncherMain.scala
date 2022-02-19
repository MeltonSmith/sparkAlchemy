package r.ian

import org.apache.spark.launcher.SparkLauncher
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by: mSmith
 * Date: 15.02.2022
 */
@SpringBootApplication
class LauncherMain

object LauncherMain {

    private val launcherBeanName = "sparkLauncher"

    def main(args: Array[String]): Unit = {
        val applicationContext = SpringApplication.run(classOf[LauncherMain])

        val launcher = applicationContext.getBean(launcherBeanName).asInstanceOf[SparkLauncher]
        launcher.launch.waitFor()
    }

}
