package com.bigdata.demo;

import java.util.Random;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/10/8 10:40
 * @ Version 1.0
 */
public class Salary {
    private String name;
    private int baseSalary;
    private int bonus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Salary() {

    }

    public Salary(String name, int baseSalary, int bonus){
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    public Salary build(){
        this.name = getRandomName(4);
        this.baseSalary = (int)(100 * Math.random());
        this.bonus = (int)(100 * Math.random());
        return this;
    }

    @Override
    public String toString() {
        return name + " " + baseSalary + " " + bonus;
    }

    /**
     * 生产Name随机函数 4位a-z随机
     * @param length
     * @return
     */
    private static String getRandomName(int length){
        String base = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< length; i++){
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
