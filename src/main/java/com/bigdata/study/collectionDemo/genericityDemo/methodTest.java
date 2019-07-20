package com.bigdata.study.collectionDemo.genericityDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :  泛型方法
 */
public class methodTest {
    public static<T> void List(T book)
    {    //定义泛型方法
        if(book!=null)
        {
            System.out.println(book);
        }
    }
    public static void main(String[] args)
    {
        Book stu=new Book(1,"细学 Java 编程",28);
        List(stu);    //调用泛型方法
    }
}
