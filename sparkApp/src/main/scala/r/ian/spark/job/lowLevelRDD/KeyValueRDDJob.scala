package r.ian.spark.job.lowLevelRDD

import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.springframework.stereotype.Service
import r.ian.spark.job.Job

/**
 * Created by: mSmith
 * Date: 12.06.2022
 */
@Service
class KeyValueRDDJob extends Job{
  /**
   * jobName for a spark job
   */
  override val jobName: String = "keyValueRddJob"



  /**
   * Should contain job logic
   */
  override def run: Unit = {

    val spark: SparkSession = buildSparkSession
    val myCollection = "Spark The Definitive Guide : Big Data Processing Made Simple"
      .split(" ")


    val words = spark.sparkContext.parallelize(myCollection, 2)


    val keyWordRdd =
      spark.sparkContext
        .parallelize(myCollection)
        .keyBy(word => word.charAt(0))
        .mapValues(value => value.toLowerCase())
        .persist(StorageLevel.MEMORY_ONLY_SER)

//    keyWordRdd
//      .collect()
//      .foreach(x => println(x))


    keyWordRdd
      .lookup('S')
      .foreach(charic => println(charic))


    val chars = words.flatMap(word => word.toLowerCase.toSeq)
    val KVcharacters = chars.map(letter => (letter, 1))

    //NOTE OOM prone since all values for a given key should
    //present on the same executor
    //its better to use
    //KVcharacters.reduceByKey(addFunc).collect()

//    KVcharacters
//      .groupByKey()
//      .map(row => (row._1, row._2.reduce(addFunc)))
//      .collect()


    //zipping. Both RDDs should have the same number of partitions and elements!
    val numRange = spark.sparkContext.parallelize(0 to 9, 2)
    val zipped = words.zip(numRange)
    zipped
      .collect()
      .foreach(a => println(a))

  }


  def maxFunc(left:Int, right:Int) = math.max(left, right)
  def addFunc(left:Int, right:Int) = left + right
}
