package com.bigdata.study.collectionDemo.genericityDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :     泛型类
 */
public class Stu<N,A,S> {
    private N name;
    private A age;
    private S sex;
    public Stu(N name, A age, S sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public N getName() {
        return name;
    }

    public void setName(N name) {
        this.name = name;
    }

    public A getAge() {
        return age;
    }

    public void setAge(A age) {
        this.age = age;
    }

    public S getSex() {
        return sex;
    }

    public void setSex(S sex) {
        this.sex = sex;
    }

}
