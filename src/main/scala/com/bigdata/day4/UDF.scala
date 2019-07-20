package com.bigdata.day4

import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

/**
  * @author : wangshengyu 
  * @date : 2019/5/4 
  */
object UDF {
  def main(args: Array[String]) {
    //设置org包下的日志级别
//    Logger.getLogger("org").setLevel(Level.WARN)
    val spark = SparkSession .builder()
      .master("local[2]")
      .appName("UDF")
      //参数spark.sql.warehouse.dir默认会在项目文件夹下面找，所以手动指定
      .config("spark.sql.warehouse.dir","D:/JD/spark-warehouse")
      .getOrCreate()
    //导入隐式转换
    import spark.implicits._

    //指定读取textFile类型的数据
    val lines:Dataset[String] = spark.read.textFile("src/main/resources/person1.txt")
    val schoolDF:DataFrame = lines.map(line => {
      val fields = line.split(" ")
      val id = fields(0)
      val name = fields(1)
      val age = fields(2)
      (id, name, age)
    }).toDF("id", "name", "age")

    var i = 0
    //定义一个自定义函数（UDF）, 并注册
    spark.udf.register("name2num",(name: String) => {
      val str = s"编号：$i " + name
      i += 1
      str
    })

    //注册视图
    schoolDF.createTempView("t_school")
    spark.sql("select name2num(name) nunName,* from t_school where age >= 20 order by age desc").show()

    spark.stop()
  }
}
