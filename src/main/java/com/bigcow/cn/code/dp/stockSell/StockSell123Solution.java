package com.bigcow.cn.code.dp.stockSell;

public class StockSell123Solution {

    public int maxProfit(int[] prices) {
        //有3种状态
        // 第一种状态 交易到第i天
        // 第二种状态 最多允许k次交易
        // 第三种状态， 0 是当前不持有股票， 1 还是当前持有股票
        int[][][] dp = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = 2; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][2][0];
    }
}
