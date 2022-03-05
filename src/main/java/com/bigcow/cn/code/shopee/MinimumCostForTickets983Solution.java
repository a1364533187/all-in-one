package com.bigcow.cn.code.shopee;

public class MinimumCostForTickets983Solution {

    public static void main(String[] args) {
        //         int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
        //        int[] days = { 1, 4, 6, 7, 8, 20 }, costs = { 7, 2, 15 };

        int[] days = { 1, 2, 3, 4, 6, 8, 9, 10, 13, 14, 16, 17, 19, 21, 24, 26, 27, 28, 29 };
        int[] costs = { 3, 14, 50 };
        System.out.println(mincostTickets(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        /**
         * 第一个参数表示旅行的第几天
         * 第二个参数表示cost的话费
         * 第三个参数表示是买消费券，还是不买
         * 0 表示买了消费券了, 可以直接消费
         * 1 表示需要买消费券使用
         */
        int[][][] dp = new int[days.length][3][2];
        dp[0][0][0] = costs[0];
        dp[0][0][1] = costs[0];
        dp[0][1][0] = costs[1];
        dp[0][1][1] = costs[1];
        dp[0][2][0] = costs[2];
        dp[0][2][1] = costs[2];
        for (int i = 1; i < days.length; i++) {
            int minPreDay = Math.min(Math.min(dp[i - 1][1][0], dp[i - 1][0][1]), dp[i - 1][2][0]);
            dp[i][0][0] = minPreDay + costs[0];
            dp[i][1][0] = minPreDay + costs[1];
            dp[i][2][0] = minPreDay + costs[2];
            // 采用为期一天，必须买券
            dp[i][0][1] = minPreDay + costs[0];
            for (int k = 0; k < i; k++) {
                //为期7天的优惠券
                if (days[i] - days[k] + 1 <= 7) {
                    dp[i][1][0] = Math.min(dp[i][1][0], dp[k][1][1]);
                }
                dp[i][1][1] = minPreDay + costs[1];
                //为期15天的优惠券
                if (days[i] - days[k] + 1 <= 15) {
                    dp[i][2][0] = Math.min(dp[i][2][0], dp[k][2][1]);
                }
                dp[i][2][1] = minPreDay + costs[2];
            }
        }
        return Math.min(Math.min(dp[days.length - 1][0][1], dp[days.length - 1][1][0]),
                dp[days.length - 1][2][0]);
    }
}
