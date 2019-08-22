package com.itcast.thread.lock;

/**
 * @author : wangshengyu
 * @date : 2019/8/22
 */
public class MysynchronizedReadWrite {
    public static void main(String[] args) {
        final MysynchronizedReadWrite test = new MysynchronizedReadWrite();

        new Thread(){
            @Override
            public void run(){
                test.get(Thread.currentThread());
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                test.get(Thread.currentThread());
            }
        }.start();
    }

    public synchronized void get(Thread thread){
        long start = System.currentTimeMillis();
        int i = 0;
        while(System.currentTimeMillis() - start <=1){
            i++;
            if(i%4==0){
                System.out.println(thread.getName()+"线程正在写入数据");
            }
            System.out.println(thread.getName()+"线程正在读取数据");
        }
    }
}
