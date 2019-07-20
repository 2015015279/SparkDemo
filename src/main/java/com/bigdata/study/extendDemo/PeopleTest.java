package com.bigdata.study.extendDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :
 */
public class PeopleTest {
    public static void main(String[] args) {
        //创建Student类
        Student stu = new Student("王丽丽",23,"女","410521198902145589","00001","计算机应用与技术");
        System.out.println("----------------学生信息--------------------");
        System.out.println(stu);

        //创建Teacher类
        Teacher tec = new Teacher("张文",30,"男","410521198203128847",5,"计算机应用与技术");
        System.out.println("----------------教师信息--------------------");
        System.out.println(tec);

    }
}
