package com.bigcow.cn.code.零钱兑换;

public class PartitionEqualSubsetSum416Solution {

    public static void main(String[] args) {
        int[] nums = { 1, 5, 10, 6 };
        System.out.println(canPartition(nums));
    }

    /**
     * //0，1 背包
     * // 暴力解法 会超时
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(nums[i], max);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        if (max > target) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) { // 物品, 避免物品被多选
            for (int j = 1; j <= target; j++) { // 背包
                if (dp[i][j]) {
                    break;
                }
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }

}
