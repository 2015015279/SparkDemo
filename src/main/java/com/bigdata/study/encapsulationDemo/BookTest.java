package com.bigdata.study.encapsulationDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :  封装
 */
public class BookTest {
    public static void main(String[] args) {
        Book book = new Book();
        book.setBookName("《红与黑》");
        book.setBookTotalNum(190);
        book.detial();

        Book book2 = new Book();
        book2.setBookName("《红与黑》");
        book2.setBookTotalNum(300);
        book2.detial();
    }
}
