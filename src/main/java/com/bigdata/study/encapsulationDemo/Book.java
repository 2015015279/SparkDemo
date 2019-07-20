package com.bigdata.study.encapsulationDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :  封装
 */
public class Book {
    private String bookName;
    private int bookTotalNum;


    public int getBookTotalNum() {
        return bookTotalNum;
    }

    public void setBookTotalNum(int bookTotalNum) {
        if(bookTotalNum<200){
            System.out.println(this.bookName+"这本书的页数不能少于 200 页");
            this.bookTotalNum = 200;
        }else {
            this.bookTotalNum = bookTotalNum;
        }
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void detial(){
        System.out.println(this.bookName+"这本书的总页数是："+this.bookTotalNum);
    }

}
