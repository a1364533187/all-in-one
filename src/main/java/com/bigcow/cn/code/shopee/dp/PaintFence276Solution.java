package com.bigcow.cn.code.shopee.dp;

public class PaintFence276Solution {

    public static void main(String[] args) {
        System.out.println(numWays(7, 2));
    }

    public static int numWays(int n, int k) {
        int[] dp = new int[n + 1];
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
        }
        return dp[n];
    }
}
