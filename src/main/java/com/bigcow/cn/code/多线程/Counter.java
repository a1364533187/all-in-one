package com.bigcow.cn.code.多线程;

import java.util.concurrent.CountDownLatch;

// 腾讯
public class Counter {

    /**
     * 10个线程计数
     * 线程1 计数1～10
     * 线程2 计数11～20
     * 线程3 计数21～30
     * 线程4 计数31～40
     * ...
     * 线程10 计数91～100
     *
     * 最后算出计算的结果
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[10];
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new CountTask(i, arr, countDownLatch));
            t.start();
        }
        countDownLatch.await();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }

}

// 测试 commit 的提交
class CountTask implements Runnable {

    private int i;
    private int[] arr;
    private CountDownLatch countDownLatch;

    public CountTask(int i, int[] arr, CountDownLatch countDownLatch) {
        this.i = i;
        this.arr = arr;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int j = 1; j <= 10; j++) {
            arr[i] += i * 10 + j;
        }
        countDownLatch.countDown();
    }
}
