package com.bigdata.study.abstractDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class Triangle extends Shape{
    public Triangle(int width,int height){
        super(width, height);
    }
    @Override
    public double area(){
        return (width*height)/2;
    }
}
