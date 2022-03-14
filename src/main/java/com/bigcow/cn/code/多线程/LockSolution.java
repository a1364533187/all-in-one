package com.bigcow.cn.code.多线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSolution {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            System.out.println("执行notify之前");
            try {
                condition.await(); // 释放锁， 被唤醒后， 执行后的代码
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行notify之后...");
            condition.signalAll();
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            lock.lock();
            System.out.println("执行notify...");
            condition.signalAll(); // 调用notify()后，并不会立即释放锁，
            // 而是继续执行当前代码，直到synchronized中的代码全部执行完毕，才会释放对象锁
            System.out.println("执行完notify...");
            lock.unlock();
        }).start();

        new CountDownLatch(1).await();
    }
}
