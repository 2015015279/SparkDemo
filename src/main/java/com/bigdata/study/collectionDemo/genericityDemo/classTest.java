package com.bigdata.study.collectionDemo.genericityDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :  泛型类
 */
public class classTest {
    public static void main(String[] args) {
        Stu<String, Integer, Character> stu = new Stu<String, Integer, Character>("小明", 12, '男');
        String name = stu.getName();
        int age = stu.getAge();
        char sex = stu.getSex();
        String a = String.valueOf(stu.getAge());
        String b = String.valueOf(stu.getSex());
        System.out.println(name);
        System.out.println(age);
        System.out.println(sex);
        System.out.println(a);
        System.out.println(b);
    }
}
