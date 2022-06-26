package com.bigcow.train;

import java.util.Arrays;

public class MatchsticksToSquare473Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        int maxValue = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
            maxValue = Math.max(maxValue, matchsticks[i]);
        }
        if (sum % 4 != 0 || maxValue > sum / 4) {
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

    /**
     * 我们对每一根火柴进行搜索，当搜索到第i根火柴的时候，将其放到4组中的一组，
     * 对于放置的每一种方法，继续对i+1根火柴进行递归搜索。当搜索完全部的火柴之后，判断每组的长度之和是否相同。
     * @param index
     * @param matchsticks
     * @param buckets
     * @param target
     * @return
     */
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
