package com.bigdata.study.objectDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :
 */
public class Student implements Cloneable{
    //实现Cloneable接口
    private String Name;
    private  int age;
    public Student(String name, int age){
        this.Name = name;
        this.age = age;
    }
    public Student(){
        this.Name = "zzz";
        this.age = 0;
    }

    public String toString(){
        return "学生名字：" + Name + "学生年龄" + age;
    }

    public static void main(String[] args) throws Exception{
        System.out.println("---------使用 new 关键字创建对象---------");

        //使用new关键字
        Student student1 = new Student("小明",12);
        System.out.println(student1);

        System.out.println("---------调用 java.lang.Class 的 newInstance() 方法创建对象---------");
        Class cl = Class.forName("com.bigdata.study.objectDemo.Student");
        Student student2=(Student)cl.newInstance();
        System.out.println(student2);

        System.out.println("-------------------调用对象的 clone() 方法创建对象----------");
        //调用对象的 clone() 方法创建对象
        Student student3=(Student)student2.clone();
        System.out.println(student3);
    }
}
