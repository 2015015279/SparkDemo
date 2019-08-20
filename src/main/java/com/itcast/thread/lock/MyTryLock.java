package com.itcast.thread.lock;

import com.bigdata.study.collectionDemo.genericityDemo.Book;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : wangshengyu
 * @date : 2019/8/21
 */
public class MyTryLock {
    private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                Thread thread = Thread.currentThread();
                Boolean tryLock = lock.tryLock();
                System.out.println(thread.getName()+" "+tryLock);
                if(tryLock){
                    try {
                        System.out.println(thread.getName() + "得到了锁");
                        for (int i = 0; i < 5; i++) {
                            arrayList.add(i);
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    } finally {
                        System.out.println(thread.getName() + "释放了锁");
                        lock.unlock();
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                Thread thread = Thread.currentThread();
                Boolean tryLock = lock.tryLock();
                System.out.println(thread.getName()+" "+tryLock);
                if(tryLock){
                    try {
                        System.out.println(thread.getName() + "得到了锁");
                        for (int i = 0; i < 5; i++) {
                            arrayList.add(i);
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    } finally {
                        System.out.println(thread.getName() + "释放了锁");
                        lock.unlock();
                    }
                }
            }
        }.start();
    }
}
