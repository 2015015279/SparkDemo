package com.bigdata.study.extendDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :
 */
public class Student extends People{
    /**
     * 学号
     * */
    private String stuNo;
    /**
     *所学专业
    **/
    private String department;

    /**
     *
    **/
    public Student(String name,int age,String sex,String sn,String stuno,String department)
    {
        //调用父类中的构造方法
        super(name,age,sex,sn);
        this.stuNo=stuno;
        this.department=department;
    }

    public String toString() {
        return "姓名：" + name + "\n年龄：" + age + "\n性别：" + sex + "\n身份证号：" + sn + "\n学号：" + stuNo + "\n所学专业：" + department;
    }
}
