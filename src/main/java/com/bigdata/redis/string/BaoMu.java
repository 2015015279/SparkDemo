package com.bigdata.redis.string;

import redis.clients.jedis.Jedis;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/11/4 11:38
 */
public class BaoMu implements Runnable {
    private Jedis jedis;
    private String redisKey;
    public BaoMu(String redisKey){
        this.redisKey = redisKey;
    }
    public void run(){
        jedis = new Jedis("192.168.183.136",6379);
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println("===================当前总共比武次数为：" + jedis.get(redisKey));
            } catch (InterruptedException e) {
                System.out.println("擂台被损坏..."+e);
            }
        }
    }
}
