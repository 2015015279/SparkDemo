package com.bigdata.day3

import java.net.URL

import org.apache.spark.{HashPartitioner, Partitioner, SparkConf, SparkContext}

import scala.collection.mutable

/**
  * @author : wangshengyu 
  * @date : 2019/5/3
  */
object UrlCountPartition {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("UrlCount")
    val sc = new SparkContext(conf)

    //将数据切分，元组（url,1）
    val rdd1 = sc.textFile("src/main/resources/itcast.log").map(line => {
      val f = line.split("\t")
      (f(1),1)
    })

    val rdd2 = rdd1.reduceByKey(_+_)

    val rdd3 = rdd2.map(t =>{
      val url = t._1
      val host = new URL(url).getHost
      (host, (url, t._2))
    })

    //对RDD进行重新分区,默认是hashPartition（hashcode碰撞）
    //rdd3.repartition(3).saveAsTextFile("src/main/resources/out1")

    //学院去重array()
    val ints = rdd3.map(_._1).distinct().collect()

//    val rdd4 = rdd3.partitionBy(new HashPartitioner(ints.length))
    //自定义分区
    val hostPartitioner = new HostPartitioner(ints)
    //对每个分区进行排序
    val rdd4 = rdd3.partitionBy(hostPartitioner).mapPartitions(it =>{
      it.toList.sortBy(_._2._2).reverse.take(3).iterator
    })
    rdd4.saveAsTextFile("src/main/resources/out2")

    sc.stop()
  }
}


//自定义分区
class HostPartitioner(ints: Array[String]) extends Partitioner{

  val parMap = new mutable.HashMap[String, Int]()
  var count = 0
  for(i <- ints){
    parMap +=(i -> count)
    count += 1
  }

  override def numPartitions: Int = ints.length

  override def getPartition(key: Any): Int = {
    parMap.getOrElse(key.toString, 0)
  }
}