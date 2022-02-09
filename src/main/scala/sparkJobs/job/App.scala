package sparkJobs.job

import org.apache.spark.sql.SparkSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by: mSmith
 * Date: 10.02.2022
 */
@Component
class App @Autowired() (private val session: SparkSession) {

  def run(): Unit = {
      session.stop();
  }
}
