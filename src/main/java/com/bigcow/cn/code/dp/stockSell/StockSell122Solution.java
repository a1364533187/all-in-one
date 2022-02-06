package com.bigcow.cn.code.dp.stockSell;

public class StockSell122Solution {

    public static int maxProfit(int[] prices) {
        //有2种状态
        // 第一种状态 交易到第几天
        // 第二种状态， 0 是当前不持有股票， 1 还是当前持有股票
        int[][] dp = new int[prices.length][2]; //截止到第i天，持有股票或者不持有股票最大的利润
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // 允许多次交易就和前面是否交易过有关
        }
        return dp[prices.length - 1][0];
    }
}