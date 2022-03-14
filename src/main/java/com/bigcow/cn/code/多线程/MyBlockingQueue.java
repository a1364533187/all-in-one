package com.bigcow.cn.code.多线程;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

/**
 * 设计一个blockingqueue
 * 有初始容量为capcity的queue
 * 支持put 方法，当queue 满的时候， 线程等待
 * 支持get 方法， 当queue 空的时候，线程等待
 */
public class MyBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(10);
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

    MyBlockingQueue(int capcity) {
        this.queue = new LinkedList<>();
        this.capacity = capcity;
    }

    // synchronized wait/notify 相当于lock 的一个条件变量
    public void put(int val) throws InterruptedException {
        synchronized (this) { // synchronized 执行完方法体的内容会释放锁
            while (queue.size() == capacity) {
                this.wait(100); // wait 也会释放锁
            }
            queue.add(val);
            this.notifyAll();
        }
    }

    public int get() throws InterruptedException {
        synchronized (this) {
            while (queue.size() == 0) {
                this.wait(100);
            }
            int val = queue.poll();
            this.notifyAll(); // 调用notify()后，并不会立即释放锁，
            // 而是继续执行当前代码，直到synchronized中的代码全部执行完毕，才会释放对象锁
            return val;
        }
    }
}
