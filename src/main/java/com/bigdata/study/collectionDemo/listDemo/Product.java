package com.bigdata.study.collectionDemo.listDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class Product
{
    //商品类
    private int id;    //商品编号
    private String name;    //名称
    private float price;    //价格
    public Product(int id,String name,float price)
    {
        this.name=name;
        this.id=id;
        this.price=price;
    }
    //这里是上面3个属性的setter/getter方法，这里省略
    public String toString()
    {
        return"商品编号："+id+"，名称:"+name+"，价格："+price;
    }
}
