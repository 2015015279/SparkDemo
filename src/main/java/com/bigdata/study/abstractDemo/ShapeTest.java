package com.bigdata.study.abstractDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 */
public class ShapeTest {
    public static void main(String[] args) {
        Square square = new Square(5,4);
        System.out.println(square.area());

        Triangle triangle = new Triangle(5,4);
        System.out.println(triangle.area());
    }
}
