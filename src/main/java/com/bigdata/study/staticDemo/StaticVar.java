package com.bigdata.study.staticDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :
 */
public class StaticVar {
    public static String str1 = "hello";

    public static void main(String[] args) {
        String str2 = "world!";
        // 直接访问str1
        String accessVar1 = str1 + str2;
        System.out.println(accessVar1);

        // 通过类名访问静态变量str1
        String accessVar2 = StaticVar.str1 + str2;
        System.out.println(accessVar2);

        //通过对象svt1访问str1
        StaticVar svt1=new StaticVar();
        svt1.str1=svt1.str1+str2;
        String accessVar3=svt1.str1;
        System.out.println("第3次访向静态变量，结果为："+accessVar3);

        //通过对象svt2访问str1
        StaticVar svt2=new StaticVar();
        String accessVar4=svt2.str1+str2;
        System.out.println("第 4 次访问静态变量，结果为："+accessVar4);

    }
}
