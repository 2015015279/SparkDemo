package com.bigdata.day3

import java.sql.DriverManager
import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author : wangshengyu
  * @date : 2019/5/3
  */
object JdbcRddDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("JdbcRddDemo").setMaster("local[2]")
    val sc = new SparkContext(conf)

    val connection = () =>{
      Class.forName("com.mysql.jdbc.Driver").newInstance()
      DriverManager.getConnection("jdbc:mysql://localhost:3306/bigdata","root","123456")
    }

    val jdbcRdd = new JdbcRDD(
      sc,
      connection,
      "SELECT * FROM location_info where id >= ? AND id <= ? and counts > 1000",
      1, 7, 3,
      r => {
        val id = r.getInt(1)
        val province = r.getString(2)
        val counts = r.getInt(3)
        val date = r.getString(4)
        (id, province, counts, date)
      }
    )

    val jrdd = jdbcRdd.collect()
    println(jdbcRdd.collect().toBuffer)
    sc.stop()
  }
}
