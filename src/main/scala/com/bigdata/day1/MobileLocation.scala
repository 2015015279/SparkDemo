package com.bigdata.day1

import java.text.SimpleDateFormat

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author : wangshengyu 
  * @date : 2019/5/2 
  */
object MobileLocation {
  def main(args: Array[String]): Unit = {
    val sdf = new SimpleDateFormat("yyyyMMddHHmmss")
    val conf = new SparkConf().setAppName("UserLocation").setMaster("local[2]")
    val sc = new SparkContext(conf)

    //读取基站信息
    sc.textFile("")
  }
}
