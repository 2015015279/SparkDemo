package com.bigdata.study.collectionDemo.bookStoreDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class Category {
    //类别编号
    private int id;
    //类别名称
    private String name;
    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
