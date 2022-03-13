package com.bigcow.cn.code.零钱兑换;

public class CoinChange2Solution {

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        System.out.println(change(5, coins));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) { //这个硬币选0个， 选1个，选2个, 最多选择amount 个
                if (i - coin >= 0) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
