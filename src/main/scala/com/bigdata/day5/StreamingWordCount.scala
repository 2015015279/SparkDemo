package com.bigdata.day5

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.log4j.{Level, Logger}

/**
  * @author : wangshengyu 
  * @date : 2019/5/4 
  */
object StreamingWordCount {
  def main(args: Array[String]): Unit = {
    //设置org包下的日志级别
    Logger.getLogger("org").setLevel(Level.WARN)
    //StreamingContext
    val conf = new SparkConf().setMaster("local[2]").setAppName("StreamingWordCount")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc,Seconds(2))

    //接收命令  nc -lk 8888
    val ds = ssc.socketTextStream("192.168.157.138",8888)
    //DStream是一个特殊的RDD
    val result = ds.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)


    //打印结果
    result.print()

    ssc.start()
    ssc.awaitTermination()

  }
}
