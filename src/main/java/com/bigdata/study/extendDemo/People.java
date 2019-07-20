package com.bigdata.study.extendDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :
 */
public class People {
    public String name;
    public int age;
    public String sex;
    public String sn;

    public People(String name, int age, String sex, String sn){
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.sn=sn;
    }

    public String toString(){
        return("姓名："+ name +"\n年龄："+age+"\n性别："+sex+"\n身份证号："+sn);
    }
}

