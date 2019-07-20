package com.bigdata.study.interfaceDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class NumTest {
    public static void main(String[] args) {
        MathClass mc = new MathClass(5,6);
        System.out.println(mc.sum());
        System.out.println(mc.maxNum(5,6));

    }
}
