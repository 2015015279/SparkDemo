package com.bigdata.day6

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * @ Author: wangshengyu
  * @ Date: 2019/10/30 12:32
  */
object ScalaKafkaStreaming {
    def main(args: Array[String]): Unit = {
        val checkpointPath = "D:\\JD\\kafka"
        val conf = new SparkConf()
                .setAppName("ScalaKafkaStreaming")
                .setMaster("local[2]")

        val sc = new SparkContext(conf)
        sc.setLogLevel("WARN")

        val ssc = new StreamingContext(sc, Seconds(5))
        ssc.checkpoint(checkpointPath)

        val bootstrapServer = "master:9092,slave1:9092,slave2:9092"
        val groupId = "kafka-test-group"
        val topicName = "spark-test"
        val maxPoll = 500

        val kafkaParams = Map(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> bootstrapServer,
            ConsumerConfig.GROUP_ID_CONFIG -> groupId,
            ConsumerConfig.MAX_POLL_RECORDS_CONFIG -> maxPoll.toString,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> classOf[StringDeserializer],
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> classOf[StringDeserializer]
        )

        val kafkaTopicDS = KafkaUtils.createDirectStream(ssc, LocationStrategies.PreferConsistent,
            ConsumerStrategies.Subscribe[String, String](Set(topicName), kafkaParams))

        kafkaTopicDS.map(_.value)
                .flatMap(_.split(" "))
                .map(x => (x, 1L))
                .reduceByKey(_ + _)
                .transform(data => {
                    val sortData = data.sortBy(_._2, false)
                    sortData
                })
                .print()

        ssc.start()
        ssc.awaitTermination()
    }
}
