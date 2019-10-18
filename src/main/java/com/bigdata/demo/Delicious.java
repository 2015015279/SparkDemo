package com.bigdata.demo;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/10/17 9:47
 */
public class Delicious {
    private String city;
    private String item;
    private String shopName;
    private String address;
    private double score1;
    private double score2;
    private double score3;
    private int avgPrice;
    private String url;

    public Delicious(String city, String item, String shopName, String address, double score1, double score2, double score3, int avgPrice, String url){
        this.city = city;
        this.item = item;
        this.shopName = shopName;
        this.address = address;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.avgPrice = avgPrice;
        this.url = url;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }

    public double getScore3() {
        return score3;
    }

    public void setScore3(double score3) {
        this.score3 = score3;
    }

    public int getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(int avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString(){
        return city + "," + item + "," + shopName + "," + address + "," + score1 + "," + score2 + "," + score3 + "," + avgPrice + "," + url;
    }
}
