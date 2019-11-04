package com.bigdata.redis.string;

import java.io.Serializable;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/11/4 11:54
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -9012113097419111583L;
    private String name;
    private int age;

    public Person(){}

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
