package com.bigcow.cn.hot100;

public class CanJump55Solution {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j < nums.length) {
                        dp[i + j] = true;
                    }
                }
            }
        }
        return dp[nums.length - 1];
    }
}
