package com.bigcow.cn.hot100;

public class LengthOfLIS300Solution {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int curMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    curMax = Math.max(curMax, dp[j] + 1);
                }
            }
            dp[i] = curMax;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
