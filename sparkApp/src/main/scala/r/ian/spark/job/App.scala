package r.ian.spark.job

import org.springframework.stereotype.Service

/**
 * Example of an bean which contains job's logic.
 *
 * Created by: mSmith
 * Date: 10.02.2022
 */
@Service
class App extends Job {

  val jobName = "app"

  def run(): Unit = {

    val spark = buildSparkSession

    spark.sparkContext.parallelize(1 to 10)
      .take(3)
      .foreach(x => println(x)) //goes to driver stout

    spark.stop();
  }
}
