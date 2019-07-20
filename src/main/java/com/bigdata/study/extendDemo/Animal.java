package com.bigdata.study.extendDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :
 */
public class Animal {
    public String name = "Animal:动物";
    public static String staticName = "Animal: 可爱的动物";
    public void  eat(){
        System.out.println("Animal: 吃饭");
    }
    public static void staticEat(){
        System.out.println("Animal: 动物们在吃饭");
    }
    public  void eatMethod()
    {
        System.out.println("Animal：动物欢吃鱼");
    }
}
