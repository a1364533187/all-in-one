package com.bigcow.cn.code.offer;

public class ShuZhiDeZhengShuCiFangLcof16Solution {

    public static void main(String[] args) {
        System.out.println(myPow(2, -2147483648));
    }

    public static double myPow(double x, int n) {
        if (x == 0) {
            return x;
        }
        int sign = 1;
        if (n == -2147483648) {
            return 1 / myPowRecur(x, 2147483640) * myPowRecur(x, 8);
        }
        if (n < 0) {
            sign = -1;
            n = -n;
        }
        return sign == 1 ? myPowRecur(x, n) : 1 / myPowRecur(x, n);

    }

    public static double myPowRecur(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            double t = myPowRecur(x, n / 2);
            return t * t;
        } else {
            double t = myPowRecur(x, (n - 1) / 2);
            return t * t * x;
        }

    }
}
