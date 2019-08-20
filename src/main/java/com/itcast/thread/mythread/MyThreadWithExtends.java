package com.itcast.thread.mythread;

import org.apache.spark.sql.catalyst.expressions.Rand;

import java.util.Random;

/**
 * @author : wangshengyu
 * @date : 2019/8/20
 */
public class MyThreadWithExtends extends Thread{
    String flag;
    public MyThreadWithExtends(String flag){
        this.flag=flag;
    }
    @Override
    public void run(){
        String tname = Thread.currentThread().getName();
        Random random = new Random();
        for(int i=0; i<10; i++){
            try {
                Thread.sleep(random.nextInt(10)*100);
                System.out.println(tname + "...." + flag);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        MyThreadWithExtends thread1 = new MyThreadWithExtends("a");
        MyThreadWithExtends thread2 = new MyThreadWithExtends("b");
        thread1.start();
        thread2.start();
        /**
        * 如果是调用run方法，则只是调用一个普通的方法，不会启动线程
        * */
//          thread1.run();
//          thread2.run();
    }
}
