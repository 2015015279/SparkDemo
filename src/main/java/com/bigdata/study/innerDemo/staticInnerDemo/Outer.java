package com.bigdata.study.innerDemo.staticInnerDemo;

import org.apache.spark.sql.sources.In;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class Outer {
    int a= 3;
    static int b = 4;
    static class Inner{
        int a=1;    //实例变量a
        static int b=2;    //静态变量 b
//        Inner i = new Inner();
//        int a2 = i.a;
//        int b2 = i.b;
    }

    public static void main(String[] args) {
        Inner i = new Outer.Inner();
        System.out.println(i.a);
        System.out.println(i.b);
        System.out.println(new Outer().a);
        System.out.println(new Outer().b);
    }
}
class OuterClass{
    Outer.Inner oi = new Outer.Inner();
    int a2=oi.a;    //访问实例成员
    int b2=Outer.Inner.b;    //访问静态成员
}
