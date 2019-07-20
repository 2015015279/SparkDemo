package com.bigdata.study.collectionDemo.bookStoreDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class Test17 {
    public static void main(String[] args)
    {
        Category category1=new Category(1,"数据库");
        Category category2=new Category(2,"程序设计");
        Category category3=new Category(3,"平面设计");
        BookInfo book1=new BookInfo(1,"细说 Java 编程",25,"张晓玲","2012-01-01");
        BookInfo book2=new BookInfo(2,"影视后期处理宝典",78,"刘水波","2012-10-05");
        BookInfo book3=new BookInfo(3,"MySQL 从入门到精通",41,"王志亮","2012-3-2");
        BookInfo book4=new BookInfo(4,"Java 从入门到精通",27,"陈奚静","2012-11-01");
        BookInfo book5=new BookInfo(5,"SQL Server 一百例",68,"张晓玲","2012-01-01");
        List<BookInfo> pList1=new ArrayList<BookInfo>();
        pList1.add(book1);
        pList1.add(book4);
        List<BookInfo> pList2=new ArrayList<BookInfo>();
        pList2.add(book3);
        pList2.add(book5);
        List<BookInfo> pList3=new ArrayList<BookInfo>();
        pList3.add(book2);
        CategoryDao.categoryMap.put(category1,pList1);
        CategoryDao.categoryMap.put(category2,pList2);
        CategoryDao.categoryMap.put(category3,pList3);
        CategoryDao.printDeptmentInfo();
    }
}
