package com.bigdata.day2

import java.net.URL

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author : wangshengyu 
  * @date : 2019/5/3 
  */
object AdvUrlCount {
  def main(args: Array[String]): Unit = {
    /*
    //从数据库加载字典表
    val arr = Array("java.itcast.cn", "php.itcast.cn", "net.itcast.cn")
    val conf = new SparkConf().setMaster("local[2]").setAppName("AdvUrlCount")
    val sc = new SparkContext(conf)

    //将数据切分，元组（url,1）
    val rdd1 = sc.textFile("src/main/resources/itcast.log").map(line => {
      val f = line.split("\t")
      (f(1),1)
    })
    val rdd2 = rdd1.reduceByKey(_+_)

    val rdd3 = rdd2.map(t =>{
      val url = t._1
      val host = new URL(url).getHost()
      (host, url, t._2)
    })

//    val rddJava = rdd3.filter(_._1 == "java.itcast.cn")
//    val rdd4 = rddJava.sortBy(_._3,false).take(3)
    for (ins <- arr){
      val rddIns = rdd3.filter(_._1 == ins)
      val resultRdd = rddIns.sortBy(_._3,false).take(3)

      //往JDBC存数据
      //id,学院，url,次数，日期
      println(resultRdd.toBuffer)
    }
*/
    val spark = SparkSession
      .builder()
      .appName("AdvUrlCount")
      //参数spark.sql.warehouse.dir默认会在项目文件夹下面找，所以手动指定
      .config("spark.sql.warehouse.dir","D:/JD/spark-warehouse")
      .master("local[2]")
      .getOrCreate()
  }
}
