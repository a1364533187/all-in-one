package com.bigcow.cn.code.零钱兑换;

public class CoinChange2Solution {

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        System.out.println(change(5, coins));
    }

    //    public static int change(int amount, int[] coins) {
    //        int[] dp = new int[amount + 1];
    //        dp[0] = 1;
    //        for (int coin : coins) {
    //            for (int i = 1; i <= amount; i++) { //这个硬币选0个， 选1个，选2个, 最多选择amount 个
    //                if (i - coin >= 0) {
    //                    dp[i] = dp[i] + dp[i - coin];
    //                }
    //            }
    //        }
    //        return dp[amount];
    //    }

    public static int change(int amount, int[] coins) {
        /**
         * dp[i][j] i 表示选择i种硬币, j 表示凑到j数量的amount
         */
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    // 只能使用第 i-1 种硬币
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 可以选择使用第i种硬币： dp[i][j - coins[i - 1]] 
                    // 可以不使用第i种硬币： dp[i - 1][j]
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
