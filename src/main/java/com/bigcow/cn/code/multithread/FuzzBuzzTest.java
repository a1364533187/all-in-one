package com.bigcow.cn.code.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

public class FuzzBuzzTest {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                new FizzBuzz(15).fizz(new Runnable() {

                    @Override
                    public void run() {
                        System.out.println("fizz");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                new FizzBuzz(15).buzz(new Runnable() {

                    @Override
                    public void run() {
                        System.out.println("buzz");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                new FizzBuzz(15).fizzbuzz(new Runnable() {

                    @Override
                    public void run() {
                        System.out.println("fizzbuzz");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                new FizzBuzz(15).number(new IntConsumer() {

                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new CountDownLatch(1).await();
    }
}
