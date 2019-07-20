package com.bigdata.day5

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * @author : wangshengyu 
  * @date : 2019/5/5
  *      计算累加
  */
object StateFulWordCount {



  val updateFunc = (iter: Iterator[(String, Seq[Int], Option[Int])]) => {
//    iter.flatMap(it=>Some(it._2.sum + it._3.getOrElse(0)).map(x=>(it._1,x)))
    //iter.map{case(x,y,z)=>Some(y.sum + z.getOrElse(0)).map(m=>(x, m))}
//    iter.map(t => (t._1, t._2.sum + t._3.getOrElse(0)))
    //case模式匹配，最外层为{}
    iter.map { case (word, current_count, history_count) => (word, current_count.sum + history_count.getOrElse(0))
    }
  }
  def main(args: Array[String]): Unit = {
    //设置org包下的日志级别
    Logger.getLogger("org").setLevel(Level.WARN)
    //StreamingContext
    val conf = new SparkConf().setMaster("local[2]").setAppName("StreamingWordCount")
    val sc = new SparkContext(conf)
    //updateStateByKey()必须设置chickpoint
    sc.setCheckpointDir("D:/JD/ck")
    val ssc = new StreamingContext(sc, Seconds(2))

    //接收命令  nl -lk 8888
    val ds = ssc.socketTextStream("192.168.157.138", 8888)
    //DStream是一个特殊的RDD
    val result = ds.flatMap(_.split(" ")).map((_, 1)).updateStateByKey(updateFunc, new HashPartitioner(sc.defaultParallelism), true)


    //打印结果
    result.print()

    ssc.start()
    ssc.awaitTermination()

    }
}
