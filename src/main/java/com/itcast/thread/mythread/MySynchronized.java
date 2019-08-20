package com.itcast.thread.mythread;

/**
 * @author : wangshengyu
 * @date : 2019/8/20
 * synchronized 同步关键字，
 */
public class MySynchronized {
    public static void main(String[] args) {
        final MySynchronized thread1 = new MySynchronized();
        final MySynchronized thread2 = new MySynchronized();

        new Thread("thread1"){
            public void run(){
                synchronized (thread1){
                    System.out.println(this.getName()+"start");
                    try {
                        Thread.sleep(500);
                        System.out.println(this.getName()+"醒了");
                        System.out.println(this.getName()+"end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("thread2"){
            public void run(){
//                synchronized (thread1){
                synchronized (thread2){
                    System.out.println(this.getName()+"start");
                    System.out.println(this.getName()+"end");
                }
            }
        }.start();
    }
}
