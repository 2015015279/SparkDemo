package com.bigdata.day4

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * @author : wangshengyu 
  * @date : 2019/5/4 
  */
object CsvDataSource {
  def main(args: Array[String]) {
    //设置org包下的日志级别
    Logger.getLogger("org").setLevel(Level.WARN)
    val spark = SparkSession .builder()
      .master("local[2]")
      .appName("CsvDataSource")
      //参数spark.sql.warehouse.dir默认会在项目文件夹下面找，所以手动指定
      .config("spark.sql.warehouse.dir","D:/JD/spark-warehouse")
      .getOrCreate()

    import spark.implicits._

    //指定读取csv类型的数据
    val csv: DataFrame = spark.read.csv("src/main/resources/person.txt")

    val schoolDF: DataFrame = csv.toDF("id","name","age")
    schoolDF.filter($"age" >= 15).sort($"age" desc).show()
    schoolDF.where($"age" >= 15).sort($"age" desc).show()

    //使用sql的方式
    schoolDF.createTempView("t_school")
    spark.sql("select * from t_school where age >= 15 order by age desc").show()

//    schoolDF.write.json("src/main/resources/person")





    spark.stop()
  }
}
