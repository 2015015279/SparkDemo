package com.bigdata.study.innerDemo.instanceInnerDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class Outer {
//    class Inner{}
//    Inner i = new Inner(); //不需要创建外部类实例
//    public void method1(){
//        Inner i = new Inner(); //不需要创建外部类实例
//    }
//    public static void method2(){
//        Inner i = new Outer().new Inner();   //需要创建外部类实例，在外部类的静态方法或外部类以外的其他类，必须通过外部类实例创建内部类的实例
//
//    }
    public int a=100;
    static int b=100;
    final int c=100;
    private int d=100;
    public String method1()
    {
        return "实例方法1";
    }
    public static String method2()
    {
        return "静态方法2";
    }
    class Inner
    {
        int a2=a+1;    //访问public的a
        int b2=b+1;    //访问static的b
        int c2=c+1;    //访问final的c
        int d2=d+1;    //访问private的d
        String str1=method1();    //访问实例方法method1
        String str2=method2();    //访问静态方法method2
    }
    public static void main(String[] args)
    {
        Inner i=new Outer().new Inner();    //创建内部类实例
        System.out.println(i.a2);    //输出101
        System.out.println(i.b2);    //输出101
        System.out.println(i.c2);    //输出101
        System.out.println(i.d2);    //输出101
        System.out.println(i.str1);    //输出实例方法1
        System.out.println(i.str2);    //输出静态方法2
    }
}
