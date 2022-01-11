package com.bigcow.cn.code.dp;

public class MaxSubArraySolution {

    // dp[i] 表示到i位置的最大和
    // dp[i-1] <= 0 dp[i] = nums[i]
    // dp[i-1] > 0 dp[i] = dp[i-1] + nums[i]
    private int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                if (dp[i - 1] <= 0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = dp[i - 1] + nums[i];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
