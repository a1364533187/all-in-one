package com.bigcow.cn.code.tencent;

public class LongestArithmeticSubsequence1027Solution {

    public int longestArithSeqLength(int[] nums) {
        // 0 <= nums[i] <= 500
        int[][] dp = new int[nums.length][1001];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1);
                res = Math.max(dp[i][d], res);
            }
        }
        return res;
    }
}
