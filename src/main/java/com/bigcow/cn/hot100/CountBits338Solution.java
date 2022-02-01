package com.bigcow.cn.hot100;

public class CountBits338Solution {

    public static void main(String[] args) {
        int[] dp = countBits(20);
        for (int i = 0; i < dp.length; i++) {
            System.out.print("-" + dp[i]);
        }
    }

    /**
     * 这解法太酷了吧
     * https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
