package r.ian.spark.job

import org.springframework.stereotype.Service

/**
 * Created by: mSmith
 * Date: 10.02.2022
 */
@Service
class App extends Job {

  var jobName = "app"

  def run(): Unit = {

    //    val entityDf = spark.read
    //      .option("delimiter", ";")
    //      .option("header", "true")
    //      .option("inferSchema", "true")
    //      .csv("file:///Users/Ian_Rakhmatullin/Desktop/FedEx/Sam/Hierarchy/SampleData/entity2.csv")

    val spark = buildSparkSession

    spark.sparkContext.parallelize(1 to 10)
      .take(3)
      .foreach(x => println(x))

    //    entityDf.take(3).foreach(x => print(x))

    spark.stop();
  }
}
