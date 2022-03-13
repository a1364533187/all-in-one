package com.bigcow.cn.code.零钱兑换;

public class CoinChange322Solution {

    public static void main(String[] args) {
        int[] coins = { 1};
        System.out.println(coinChange(coins, 0));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) { // 背包
            dp[i] = 1000;
            for (int j = 0; j < coins.length; j++) { // 物品
                if (i - coins[j] >= 0 && dp[i - coins[j]] != 1000) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == 1000 ? -1 : dp[amount];
    }

}
