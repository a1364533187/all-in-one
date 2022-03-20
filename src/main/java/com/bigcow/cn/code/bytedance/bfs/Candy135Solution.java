package com.bigcow.cn.code.bytedance.bfs;

public class Candy135Solution {

    public static void main(String[] args) {
        //        //        int[] ratings = { 1, 0, 2 };
        //        int[] ratings = { 1, 2, 2 };
        int[] ratings = { 1, 3, 4, 5, 2 };
        //        int[] ratings = { 4, 3, 1, 0, 5, 6, 7 };
        System.out.println(candy(ratings));
    }

    /**
     * https://cloud.tencent.com/developer/article/1879610
     * 贪心策略：
     * 从左到右遍历，只比较右孩子评分比左边大的情况
     * 从右到左遍历，只比较左孩子评分比右边大的情况
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        // 向后贪心
        dp[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        // 往前贪心
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // int[] ratings = { 1, 3, 4, 5, 2 };
                // 从前往后 dp[1,2,3,4,1]
                // 从后往前 dp[1,2,3,4,1]
                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            }
        }

        int sum = 0;
        //求和
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
