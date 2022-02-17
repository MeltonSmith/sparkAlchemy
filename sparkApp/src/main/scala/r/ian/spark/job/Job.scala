package r.ian.spark.job

import org.apache.spark.sql.SparkSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by: mSmith
 * Date: 10.02.2022
 */
@Service
trait Job {

  var jobName: String

  @Autowired
  val sparkBuilder: SparkSession.Builder = null

  def buildSparkSession: SparkSession = {
    sparkBuilder.appName(jobName).getOrCreate()
  }

  /**
   * Should contain job logic
   */
  def run
}
