package com.itcast.thread.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : wangshengyu
 * @date : 2019/8/21
 */
public class MyLockTest {
    private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                Thread thread = Thread.currentThread();
                lock.lock();
                try{
                    System.out.println(thread.getName() + "拿到了锁");
                    for(int i=0; i<5; i++){
                        arrayList.add(i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println(thread.getName() + "释放了锁");
                    lock.unlock();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                Thread thread = Thread.currentThread();
                lock.lock();
                try{
                    System.out.println(thread.getName() + "拿到了锁");
                    for(int i=0; i<5; i++){
                        arrayList.add(i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println(thread.getName() + "释放了锁");
                    lock.unlock();
                }
            }
        }.start();
    }
}
