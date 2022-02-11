package com.bigcow.cn.code.multithread;

import java.util.concurrent.Semaphore;

public class FooBar {

    public static void main(String[] args) {
        Semaphore switchFoo = new Semaphore(1);
        System.out.println(switchFoo.tryAcquire());
        System.out.println(switchFoo.tryAcquire());
    }

    private int n;

    Semaphore switchFoo = new Semaphore(1);
    Semaphore switchBar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            switchFoo.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            switchBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            switchBar.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            switchFoo.release();
        }
    }
}
