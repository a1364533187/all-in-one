package com.bigcow.cn.hot100;

public class CoinChange322Solution {

    public static void main(String[] args) {
        int[] coins = { 2 };
        System.out.println(coinChange(coins, 3));

    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) { // 背包
            int curMin = Integer.MAX_VALUE;
            for (int coin : coins) { // 物品
                if (i >= coin && dp[i - coin] != -1) {
                    curMin = Math.min(curMin, dp[i - coin] + 1);
                }
            }
            if (curMin == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = curMin;
            }
        }
        return dp[amount];
    }

}
