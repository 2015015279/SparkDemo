package com.bigdata.day6;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/10/30 14:44
 */
public class ProducerTest {
    private static final String[] WORDS = {
            "hello","hadoop","java","kafka","spark"
    };

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("bootstrap.servers", "master:9092,slave1:9092,slave2:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(props);
        boolean flag = true;
        while(flag){
            for(int i=0; i<500; i++){
                kafkaProducer.send(new ProducerRecord("spark-test", WORDS[new Random().nextInt(5)]));
            }
            kafkaProducer.flush();
            System.out.println(("=============kafka flush================="));
            Thread.sleep(1000);
        }
        kafkaProducer.close();
    }
}
