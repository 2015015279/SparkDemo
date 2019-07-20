package com.bigdata.study.collectionDemo.listDemo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class ArrayListTest {
    public static void main(String[] args) {
        Product p1 = new Product(1,"牙膏",12);
        Product p2 = new Product(2,"牙刷",14);
        Product p3 = new Product(3,"洗发水",18);
        ArrayList list = new ArrayList();
        list.add(p1);
        list.add(p2);
        list.add(p3);
//        for(int i=0; i<list.size(); i++){
////            System.out.println(list.get(i));
//            Product product = (Product) list.get(i);
//            System.out.println(product);
//        }
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
