package com.bigdata.study.collectionDemo.genericityDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :      泛型集合
 */
public class collectionTest {
    public static void main(String[] args) {
        Book book1 = new Book(1,"唐诗三百首",8);
        Book book2 = new Book(2,"小星星",12);
        Book book3 = new Book(3,"成语大全",22);
        Map<Integer, Book> books = new HashMap<Integer, Book>();
        books.put(1001, book1);
        books.put(1002, book2);
        books.put(1003, book3);
        System.out.println("泛型Map存储的图书信息如下：");
        for(Integer id: books.keySet()){
            System.out.print(id+"---");
            System.out.println(books.get(id));
        }

        List<Book> list = new ArrayList<Book>();
        list.add(book1);
        list.add(book2);
        list.add(book3);
        for(Book b:list){
            System.out.println(b);
        }

        List blist = new ArrayList();
        blist.add(book1);
        blist.add(book2);
        blist.add(book3);
        for(int i=0; i<blist.size(); i++){
            Book b = (Book)blist.get(i);
            System.out.println(b);
        }
    }
}
