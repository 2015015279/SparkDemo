package com.bigdata.study.extendDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :
 */
public class Cat extends Animal {
    public String name = "Cat:小猫";
    public String str = "Cat：可爱的小猫";
    public static String staticName = "Dog：我是喵星人";

    public void eat() {
        System.out.println("Cat：吃饭");
    }

    public static void staticEat() {
        System.out.println("Cat：猫在吃饭");
    }

    public void eatMethod() {
        System.out.println("Cat：猫喜欢吃鱼");
    }

    public static void main(String[] args) {
        Cat animal = new Cat();
        Cat cat = animal;    //向下转型
        System.out.println(animal.name);    //输出Animal类的name变量
        System.out.println(animal.staticName);    // 输出Animal类的staticName变量
        animal.eat();    //输出Cat类的eat()方法
        animal.staticEat();    //输出Animal类的staticEat()方法
        System.out.println(cat.str);    //调用Cat类的str变量
        cat.eatMethod();    //调用Cat类的eatMethod()方法
        animal.eatMethod();
    }
}
