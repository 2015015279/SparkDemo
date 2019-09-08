package com.itcast.reflect;

import java.io.Serializable;

/**
 * @author : wangshengyu
 * @date : 2019/9/7
 */
public class Person implements Serializable{
    private Long id;
    public String name;

    public Person() {
        this.id = 100L;
        this.name = "afs";
    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(Long id) {
        super();
        this.id = id;
    }

    private Person(String name) {
        super();
        this.name = name+"=======";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person [id="+ id + ", name=" + name + "]";
    }

    private String getSomeThing() {
        return "sdsadasdsasd";
    }

    private void testPrivate(){
        System.out.println("this is a private method");
    }

}
