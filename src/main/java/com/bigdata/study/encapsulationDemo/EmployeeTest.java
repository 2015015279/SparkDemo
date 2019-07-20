package com.bigdata.study.encapsulationDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :
 */
public class EmployeeTest {
    public static void main(String[] args) {
//        Employee e = new Employee();
//        e.setName("xiaowang");
//        e.setAge(12);
//        e.setPhone("123456789");
//        e.setAdress("beijing");
        Employee e = new Employee("xiaoming",12,"123456789","beijing");
        System.out.println("姓名："+e. getName());
        System.out.println("年龄："+e.getAge());
        System.out.println("电话："+e.getPhone());
        System.out.println("家庭住址："+e.getAdress());

        System.out.print(e.getAll());
    }
}
