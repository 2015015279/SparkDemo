package com.bigdata.redis.sortSet;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/11/4 15:14
 */
public class SortMain {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.183.136", 6379);
        jedis.zadd("比武成绩", 10, "乔峰");
        jedis.zadd("比武成绩", 5, "王重阳");
        jedis.zadd("比武成绩", 7, "虚竹");
        jedis.zadd("比武成绩", 2, "王语嫣");
        jedis.zadd("比武成绩", 5, "段誉");
        jedis.zadd("比武成绩", 4, "峨眉师太");
        jedis.zadd("比武成绩", 20, "张三丰");
        Set<String> names = jedis.zrange("比武成绩",0,-1);
        for(String name: names){
            System.out.println((name + "        排名： "
                    //打印用户升序排行
                    + jedis.zrank("比武成绩", name) + "           赢的场次： "
                    //打印用户的比武成绩
                    + jedis.zscore("比武成绩", name)));
        }
        System.out.println("==============================");

        names = jedis.zrevrange("比武成绩", 0, -1);
        for (String name : names) {
            System.out.println(name + "         "
                    + jedis.zrevrank("比武成绩", name) + "            "
                    + jedis.zscore("比武成绩", name));
        }
        System.out.println("==============================");

        //修改用户的分数
        jedis.zincrby("比武成绩",100,"王语嫣");
        names = jedis.zrevrange("比武成绩", 0, -1);
        for (String name : names) {
            System.out.println(name + "         "
                    + jedis.zrevrank("比武成绩", name) + "            "
                    + jedis.zscore("比武成绩", name));
        }
    }
}
