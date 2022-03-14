package com.bigcow.cn.code.多线程;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 设计一个blockingqueue
 * 有初始容量为capcity的queue
 * 支持put 方法，当queue 满的时候， 线程等待
 * 支持get 方法， 当queue 空的时候，线程等待
 */
public class MyBlockingQueue1 {

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue1 myBlockingQueue = new MyBlockingQueue1(10);
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(1000);
                    myBlockingQueue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(myBlockingQueue.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(myBlockingQueue.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    System.out.println(myBlockingQueue.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new CountDownLatch(1).await();

        //        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(10);
        //        myBlockingQueue.put(3);
        //        System.out.println(myBlockingQueue.get());
    }

    private int capacity;
    private Queue<Integer> queue;

    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    MyBlockingQueue1(int capcity) {
        this.queue = new LinkedList<>();
        this.capacity = capcity;
    }

    public void put(int val) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                condition.await();
            }
            queue.add(val);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int get() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                condition.await();
            }
            int val = queue.poll();
            condition.signalAll();
            return val;
        } finally { // 一定finally 释放锁
            lock.unlock();
        }
    }
}
