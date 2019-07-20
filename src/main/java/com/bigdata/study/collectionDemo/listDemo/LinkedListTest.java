package com.bigdata.study.collectionDemo.listDemo;

import java.util.LinkedList;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> llist = new LinkedList<String>();
        String p1 = "六角螺母";
        String p2 = "10A 电缆线";
        String p3 = "5M 卷尺";
        String p4 = "4CM 原木方板";
        llist.add(p1);
        llist.add(p2);
        llist.add(p3);
        llist.add(p4);
        String p5 = "标准文件夹小柜";
        String p6 = "标准文件夹大柜";
        llist.addLast(p5);
        llist.addFirst(p6);
        for(int i=0; i<llist.size(); i++){
            System.out.println(llist.get(i));
        }

    }
}
