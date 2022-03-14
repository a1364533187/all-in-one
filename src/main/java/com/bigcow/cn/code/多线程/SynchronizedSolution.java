package com.bigcow.cn.code.多线程;

import java.util.concurrent.CountDownLatch;

public class SynchronizedSolution {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("执行notify之前");
                try {
                    lock.wait(); // 释放锁， 被唤醒后， 执行后的代码
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行notify之后...");
            }
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("执行notify...");
                lock.notify(); // 调用notify()后，并不会立即释放锁，
                // 而是继续执行当前代码，直到synchronized中的代码全部执行完毕，才会释放对象锁
                System.out.println("执行完notify...");
            }
        }).start();

        new CountDownLatch(1).await();
    }
}
