package com.bigdata.study.exceptionDemo;
import java.util.Scanner;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */

public class Test3{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("---------学生信息录入---------------");
        String name="";    //获取学生姓名
        int age=0;    //获取学生年龄
        String sex="";    //获取学生性别
        try{
            System.out.println("请输入学生姓名：");
            name=scanner.next();
            System.out.println("请输入学生年龄：");
            age=scanner.nextInt();
            System.out.println("请输入学生性别：");
            sex=scanner.next();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("输入有误！");
        }
        System.out.println("姓名："+name);
        System.out.println("年龄："+age);
        System.out.println("年龄："+sex);
    }
}
