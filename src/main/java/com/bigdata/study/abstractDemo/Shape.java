package com.bigdata.study.abstractDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc : 抽象类
 */
public abstract class Shape {
    public int width;
    public int height;

    public Shape(int width, int height){
        this.width = width;
        this.height = height;
    }

    public abstract double area();
}
