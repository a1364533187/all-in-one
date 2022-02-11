package com.bigcow.cn.code.multithread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;

    Semaphore s0_0 = new Semaphore(1); // 0
    Semaphore s1_odd = new Semaphore(0); //奇数
    Semaphore s2_even = new Semaphore(0); //偶数

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s0_0.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                s1_odd.release();
            } else {
                s2_even.release();
            }
        }
    }

    // 打印偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n / 2; i++) {
            s2_even.acquire();
            int number = 2 * i + 2;
            printNumber.accept(number);
            s0_0.release();
        }
    }

    // 打印奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < (n + 1) / 2; i++) {
            s1_odd.acquire();
            int number = 2 * i + 1;
            printNumber.accept(number);
            s0_0.release();
        }
    }
}
