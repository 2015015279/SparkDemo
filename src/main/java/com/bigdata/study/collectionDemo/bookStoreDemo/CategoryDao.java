package com.bigdata.study.collectionDemo.bookStoreDemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class CategoryDao {
    public static Map<Category, List<BookInfo>> categoryMap = new HashMap<Category, List<BookInfo>>();
    public static void printDeptmentInfo(){
        for(Category category: categoryMap.keySet()){
            System.out.println("所属类别:" + category.getName());
            List<BookInfo> books = categoryMap.get(category);
            System.out.println("图书编号\t\t图书名称\t\t图书价格\t\t图书作者\t\t出版时间");
//            for(int i=0;i<books.size();i++)
//            {
//                BookInfo b=books.get(i);    //获取图书
//                System.out.println(b.getId()+"\t\t"+b.getName()+"\t\t"+b.getPrice()+"\t\t"+b.getAuthor()+"\t\t"+b.getStartTime());
//            }
            for(BookInfo b:books){
                System.out.println(b);
            }
            System.out.println();
        }
    }
}
