package com.bigdata.study.collectionDemo.genericityDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class Book {
    private int id;
    private String name;
    private int price;

    public Book(int id, String name, int price){
        this.id= id;
        this.name = name;
        this.price = price;
    }

    public String toString(){
        return this.id+", "+this.name+"，"+this.price;
    }
}
