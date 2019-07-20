package com.bigdata.day4

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * @author : wangshengyu 
  * @date : 2019/5/4 
  */
object JdbcDataSource {
  def main(args: Array[String]) {
    //设置org包下的日志级别
    Logger.getLogger("org").setLevel(Level.WARN)
    val spark = SparkSession .builder()
      .master("local[2]")
      .appName("JdbcDataSource")
      //参数spark.sql.warehouse.dir默认会在项目文件夹下面找，所以手动指定
      .config("spark.sql.warehouse.dir","D:/JD/spark-warehouse")
      .getOrCreate()

    import spark.implicits._
    val schoolDF:DataFrame = spark.read.format("jdbc").options(
      Map("url" -> "jdbc:mysql://localhost:3306/bigdata",
        "driver" -> "com.mysql.jdbc.Driver",
        "dbtable" -> "location_info",
        "user" -> "root",
        "password" -> "123456")
    ).load()

    //schoolDF.printSchema()
    //schoolDF.show()

    schoolDF.select($"location",$"counts").show()
    schoolDF.filter($"counts" >= 1000).sort($"counts" desc).show()
    schoolDF.where($"counts" >= 1000).sort($"counts" desc).show()

    //使用sql的方式
    schoolDF.createTempView("t_ip")
    spark.sql("select * from t_ip where counts >= 1000 order by counts desc").show()

    spark.stop()

  }
}
