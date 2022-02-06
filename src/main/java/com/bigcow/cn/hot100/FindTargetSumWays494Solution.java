package com.bigcow.cn.hot100;

public class FindTargetSumWays494Solution {

    public static void main(String[] args) {
        int[] nums = { 1 };
        System.out.println(findTargetSumWays(nums, 1));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int[] count = new int[1];
        DFS(nums, target, 0, count);
        return count[0];
    }

    private static void DFS(int[] nums, int target, int index, int[] count) {
        if (index >= nums.length) {
            if (index == nums.length && target == 0) {
                count[0]++;
            }
            return;
        }
        DFS(nums, target + nums[index], index + 1, count);
        DFS(nums, target - nums[index], index + 1, count);
    }
}
