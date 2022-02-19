package r.ian.spark.job

import org.apache.spark.sql.SparkSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Main trait for a spark job
 *
 * Created by: mSmith
 * Date: 10.02.2022
 */
@Service
trait Job {

  /**
   * jobName for a spark job
   */
  val jobName: String

  @Autowired
  val sparkBuilder: SparkSession.Builder = null

  final def buildSparkSession: SparkSession = {
    sparkBuilder.appName(jobName).getOrCreate()
  }

  /**
   * Should contain job logic
   */
  def run
}
