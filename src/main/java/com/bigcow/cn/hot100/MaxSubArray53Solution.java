package com.bigcow.cn.hot100;

public class MaxSubArray53Solution {
    // -2,1,-3,4,-1,2,1,-5,4
    // -2,1,-2,4, 3,5,6, 1,5
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i-1];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
