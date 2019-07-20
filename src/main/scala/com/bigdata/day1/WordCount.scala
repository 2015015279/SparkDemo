package com.bigdata.day1

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author : wangshengyu 
  * @date : 2019/5/2 
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WC")
    val sc = new SparkContext(conf)

    //textFile会产生两个RDD 1.HadoopRDD -> MapPartitionsRDD
    sc.textFile(args(0))
      //产生一个RDD：MapPartitionsRDD
      .flatMap(_.split(" "))
      //产生一个RDD：MapPartitionsRDD
      .map((_, 1))
      //产生一个RDD：ShuffledRDD
      .reduceByKey(_+_)
      //产生一个RDD：mapPartitions
      .saveAsTextFile(args(1))
    sc.stop()
  }
}
