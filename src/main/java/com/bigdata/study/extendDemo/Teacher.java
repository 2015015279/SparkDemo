package com.bigdata.study.extendDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :
 */
public class Teacher extends People {
    private int tYear;
    private String tDept;

    public Teacher(String name, int age, String sex, String sn, int tYear, String tDept) {
        super(name, age, sex, sn);
        this.tYear = tYear;
        this.tDept = tDept;
    }

    public String toString() {
        return "姓名：" + name + "\n年龄：" + age + "\n性别:" + sex + "\n身份证号：" + sn + "\n教龄：" + tYear + "\n所教专业：" + tDept;
    }
}
