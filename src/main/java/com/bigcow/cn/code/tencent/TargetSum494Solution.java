package com.bigcow.cn.code.tencent;

public class TargetSum494Solution {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        System.out.println(findTargetSumWays(nums, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int[] res = new int[1];
        dfs(nums, target, 0, res);
        return res[0];
    }

    private static void dfs(int[] nums, int target, int start, int[] res) {
        if (start >= nums.length) {
            if (target == 0) {
                res[0]++;
            }
            return;
        }
        // 选择 + 1
        dfs(nums, target + nums[start], start + 1, res);
        // 选择 - 1
        dfs(nums, target - nums[start], start + 1, res);
    }
}
