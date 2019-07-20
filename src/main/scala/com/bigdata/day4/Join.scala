package com.bigdata.day4

import org.apache.spark.sql.{Dataset, SparkSession}

/**
  * @author : wangshengyu 
  * @date : 2019/5/4 
  */
object Join {
  def main(args: Array[String]) {
    //设置org包下的日志级别
//    Logger.getLogger("org").setLevel(Level.WARN)
    val spark = SparkSession .builder()
      .master("local[2]")
      .appName("Join")
      //参数spark.sql.warehouse.dir默认会在项目文件夹下面找，所以手动指定
      .config("spark.sql.warehouse.dir","D:/JD/spark-warehouse")
      .getOrCreate()

    import spark.implicits._

    val stuDS: Dataset[String] = spark.createDataset(List("1,zhangsan,china", "2,lisi,usa", "3,wangwu,jp"))
    val stuDF = stuDS.map(line => {
      val fields = line.split(",")
      val id = fields(0).toLong
      val name = fields(1)
      val nationCode = fields(2)
      (id, name, nationCode)
    }).toDF("id", "name", "nation")

    val nationDS: Dataset[String] = spark.createDataset(List("china,中国", "usa,美国"))
    val nationDF = nationDS.map(line => {
      val fields = line.split(",")
      val ename = fields(0)
      val cname = fields(1)
      (ename, cname)
    }).toDF("code","name")

    //方式一：创建视图
    stuDF.createTempView("t_user")
    nationDF.createTempView("t_nation")
    spark.sql("SELECT u.name, n.name FROM t_user u JOIN t_nation n ON u.nation = n.code").show()

    //方式二
    /**
      * JoinType :
      *         "inner",
      *         "outer", "full", "fullouter",
      *         "leftouter", "left",
      *         "rightouter", "right",
      *         "leftsemi"
      */
    stuDF.join(nationDF, $"nation" === $"code", "left").show()
    stuDF.join(nationDF, stuDF("nation") === nationDF("code"), "left").show()
    stuDF.join(nationDF, stuDF("nation") === nationDF("code"), "right").show()
    stuDF.join(nationDF, stuDF("nation") === nationDF("code"), "inner").show()

    spark.stop()
  }
}
