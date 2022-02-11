package com.bigcow.cn.hot100;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128Solution {

    public static void main(String[] args) {
        int[] nums = { 0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                continue;
            }
            int count = 1;
            while (set.contains(++nums[i])) {
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
