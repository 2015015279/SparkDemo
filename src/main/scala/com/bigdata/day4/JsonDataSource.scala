package com.bigdata.day4

import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * @author : wangshengyu 
  * @date : 2019/5/4 
  */
object JsonDataSource {
  def main(args: Array[String]) {
    //设置org包下的日志级别
//    Logger.getLogger("org").setLevel(Level.WARN)
    val spark = SparkSession .builder()
      .master("local[2]")
      .appName("JsonDataSource")
      //参数spark.sql.warehouse.dir默认会在项目文件夹下面找，所以手动指定
      .config("spark.sql.warehouse.dir","D:/JD/spark-warehouse")
      .getOrCreate()

    import spark.implicits._

    //指定读取json类型的数据(有表头)
    val schoolDF:DataFrame = spark.read.json("src/main/resources/person.json")
    schoolDF.select("name","age").filter($"age" >= 20).sort($"age" desc).show()
    schoolDF.where($"age" >= 20).sort($"age" desc).show()

    //使用sql的方式
    schoolDF.createTempView("t_school")
    spark.sql("select id,name from t_school where age >= 20 order by age desc").show()

    spark.stop()

  }
}
