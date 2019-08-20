package com.itcast.thread.mythread;

import java.util.Random;

/**
 * @author : wangshengyu
 * @date : 2019/8/20
 */
public class MyThreadImpliment implements Runnable{
    String flag;
    public MyThreadImpliment(String flag){
        this.flag=flag;
    }
    @Override
    public void run(){
        String tname = Thread.currentThread().getName();
        Random random = new Random();
        for(int i=0; i<10; i++){
            try {
                Thread.sleep(random.nextInt(10)*100);
                System.out.println(tname + "..." + flag);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThreadImpliment("1"),"t1");
        Thread thread2 = new Thread(new MyThreadImpliment("2"),"t2");
        thread1.start();
        thread2.start();
    }
}
