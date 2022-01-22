package com.bigcow.cn.code.dp;

public class NumSquaresSolution {

    /**
     * 在本题中，位置 i 只依赖 i - k*k 的位置，如 i - 1、i - 4、i - 9 等等，
     * 才能满足完全平方分割 的条件。
     * 因此 dp[i] 可以取的最小值即为 1 + min(dp[i-1], dp[i-4], dp[i-9] · · · )。
     *
     * https://leetcode-cn.com/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/
     */
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; //最坏的情况就是每次+1
            for (int k = 1; i - k * k >= 0; k++) {
                dp[i] = Math.min(dp[i], dp[i - k * k] + 1);
            }
        }
        return dp[n];
    }
}
