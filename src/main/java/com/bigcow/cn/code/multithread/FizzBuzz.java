package com.bigcow.cn.code.multithread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;

    Semaphore fizzS = new Semaphore(0);
    Semaphore buzzS = new Semaphore(0);
    Semaphore fizzbuzzS = new Semaphore(0);
    Semaphore numberS = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (i%3 == 0) {
                fizzS.acquire();
                printFizz.run();
                numberS.release();
            }
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        buzzS.acquire();
        printBuzz.run();
        numberS.release();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        fizzbuzzS.acquire();
        printFizzBuzz.run();
        numberS.release();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            numberS.acquire();
            boolean canMod3 = i % 3 == 0;
            boolean canMod5 = i % 5 == 0;
            if (canMod3 && canMod5) {
                fizzbuzzS.release();
            } else if (canMod3) {
                fizzS.release();
                System.out.println();
            } else if (canMod5) {
                buzzS.release();
            } else {
                printNumber.accept(i);
                numberS.release();
            }
        }
    }
}
