package com.bigdata.study;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :
 */
public class WorkTest {
    public static void main(String[] args)
    {
        System.out.println("-----------带有一个参数的构造方法-----------");
        //调用带有一个参数的构造方法，Staff类中的sex和age属性值不变
        Worker worker1=new Worker("张强");
        System.out.println(worker1);
        System.out.println("-----------带有两个参数的构造方法------------");
        //调用带有两个参数的构造方法，Staff类中的sex属性值不变
        Worker worker2=new Worker("李丽",25);
        System.out.println(worker2);
    }
}
