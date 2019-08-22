package com.itcast.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : wangshengyu
 * @date : 2019/8/23
 */
public class MyReentrantReadWrite {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args)  {
        final MyReentrantReadWrite test = new MyReentrantReadWrite();

        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
                test.write(Thread.currentThread());
            };
        }.start();

        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
                test.write(Thread.currentThread());
            };
        }.start();

    }

    /**
     * 读操作,用读锁来锁定
     * @param thread
     */
    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }

    /**
     * 写操作，用写锁来锁定
     * @param thread
     */
    public void write(Thread thread) {
        rwl.writeLock().lock();
        try {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行写操作");
            }
            System.out.println(thread.getName()+"写操作完毕");
        } finally {
            rwl.writeLock().unlock();
        }
    }

}
