package com.bigdata.study.collectionDemo.bookStoreDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class BookInfo {
    private int id; //编号
    private String name; //书名
    private int price;  //价格
    private String author; //作者
    private String startTime;   //出版时间

    public BookInfo(int id, String name, int price, String author, String startTime){
        this.author = author;
        this.id =id;
        this.name =name;
        this.price = price;
        this.startTime = startTime;
    }

    public String toString(){
        return this.id+"\t\t"+this.name+"\t\t"+this.price+"\t\t"+this.author+"\t\t"+this.startTime;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
