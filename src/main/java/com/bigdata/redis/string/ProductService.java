package com.bigdata.redis.string;

import com.google.gson.Gson;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/11/4 11:57
 */
public class ProductService {
    @Test
    public void saveProduct2Redis() throws Exception{
        Person person = new Person("刘德华",17);
        Jedis jedis = new Jedis("192.168.183.136", 6379);
        jedis.set("user:liudehua:str", person.toString());
        System.out.println(jedis.get("user:liudehua:str"));

        //保存序列化之后的对象
        jedis.set("user:liudehua:obj".getBytes(), getBytesByProduct(person));
        byte[] productBytes = jedis.get("user:liudehua:obj".getBytes());
        Person pByte = getProductByBytes(productBytes);
        System.out.println(pByte.getName()+"  " +pByte.getAge());

        //保存Json化之后的对象
        jedis.set("user:liudehua:json", new Gson().toJson(person));
        String personJson = jedis.get("user:liudehua:json");
        Person pjson = new Gson().fromJson(personJson, Person.class);
        System.out.println(pjson.getName()+"  "+ pjson.getAge());


    }

    /**
     * 从字节数组中读取Java对象
     *
     * @param productBytes
     * @return
     * @throws Exception
     */
    public Person getProductByBytes(byte[] productBytes) throws Exception {
        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(productBytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
        return (Person) objectInputStream.readObject();
    }

    /**
     * 将对象转化成Byte数组
     *
     * @param product
     * @return
     * @throws Exception
     */
    public byte[] getBytesByProduct(Person product) throws Exception {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(ba);
        oos.writeObject(product);
        oos.flush();
        return ba.toByteArray();
    }
}
