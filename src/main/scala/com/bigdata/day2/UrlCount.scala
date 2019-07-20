package com.bigdata.day2

import java.net.URL

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author : wangshengyu 
  * @date : 2019/5/2 
  */
object UrlCount {
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
      (host, url, t._2)
    })

    val rdd4 = rdd3.groupBy(_._1).mapValues(it =>{
      it.toList.sortBy(_._3).reverse.take(3)
    })

    println(rdd4.collect().toBuffer)
    sc.stop()
  }
}
