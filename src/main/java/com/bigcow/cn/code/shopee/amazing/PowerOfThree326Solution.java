package com.bigcow.cn.code.shopee.amazing;

public class PowerOfThree326Solution {

    public static void main(String[] args) {
        System.out.println(calMax3Power()); // 1162261467
    }

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    private static int calMax3Power() {
        int res = 9;
        while (res <= Integer.MAX_VALUE / 3) {
            res = res * 3;
        }
        return res ;
    }
}
