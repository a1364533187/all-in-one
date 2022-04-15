package com.bigcow.cn.code.microsoft;

/**
 * 非常经典的题目
 * 需要注意负值变为正数的溢出
 */
public class PowxN50Solution {

    public double myPow(double x, int n) {
        if (n == -2147483648) { // 整数的
            return 1 / (myPow(x, -n - 1) * x);
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 1) {
            double t = myPow(x, n / 2);
            return t * t * x;
        } else {
            double t = myPow(x, n / 2);
            return t * t;
        }
    }

}
