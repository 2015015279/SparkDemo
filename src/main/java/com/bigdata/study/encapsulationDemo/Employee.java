package com.bigdata.study.encapsulationDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :  封装
 */
public class Employee {

    private String name;
    private int age;
    private String phone;
    private String adress;

    public Employee(String name, int age, String phone, String adress){
        this.name = name;
        this.age =age;
        this.phone = phone;
        this.adress = adress;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdress() {
        return adress;
    }

    public String getAll(){
        return this.name + "\t" + this.age + "\t" + this.phone + "\t" +this.adress;
    }


}
