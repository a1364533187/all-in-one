package com.bigcow.cn.code.tree.子集;

import java.util.Arrays;

public class MatchsticksToSquare473Solution {

    public static void main(String[] args) {
        int[] matchsticks = { 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3 };
        System.out.println(makesquare(matchsticks));
    }

    public static boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;
        int[] backets = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks, 0, matchsticks.length - 1);
        return dfs(0, matchsticks, backets, target);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static boolean dfs(int index, int[] matchsticks, int[] buckets, int target) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (buckets[i] + matchsticks[index] > target) {
                continue;
            }
            buckets[i] += matchsticks[index];
            if (dfs(index + 1, matchsticks, buckets, target)) {
                return true;
            }
            buckets[i] -= matchsticks[index];
        }
        return false;
    }
}
