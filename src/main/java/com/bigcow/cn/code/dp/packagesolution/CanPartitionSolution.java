package com.bigcow.cn.code.dp.packagesolution;

import java.util.Arrays;

public class CanPartitionSolution {

    public static void main(String[] args) {
        int[] nums = { 1, 11, 5, 5 };
        System.out.println(canPartition(nums));
    }

    // 0-1 背包问题
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        // 再填表格后面几行
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
        //        return canPartitionComb(nums, target);
    }

    // 一、暴力法，组合问题 + 剪枝
    public static boolean canPartitionComb(int[] nums, int target) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, target, 0);
    }

    private static boolean dfs(int[] nums, int target, int begin) {
        if (target == 0) {
            return true;
        }
        for (int i = begin; i < nums.length; i++) {
            if (target - nums[i] < 0) {
                continue;
            }
            if (dfs(nums, target - nums[i], i + 1)) {
                return true;
            }
        }
        return false;
    }

    // 二、背包

}
