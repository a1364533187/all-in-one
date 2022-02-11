package com.bigcow.cn.code.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15Solution {

    public static void main(String[] args) {
        //        int[] nums = { 1, 3, 1, 2, 2, 3 };
        //        Arrays.sort(nums);
        //        List<List<Integer>> res = twoSum(nums, 4, 0, nums.length - 1);
        //        System.out.println(res);

        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(nums));
    }

    // 一个方法从 2Sum 秒杀到 100Sum
    // https://leetcode-cn.com/problems/3sum/solution/yi-ge-fang-fa-tuan-mie-by-labuladong/
    // nums 已经排序， 找到和为target 的数， 起始位置为start, 结束位置为end 
    public static List<List<Integer>> twoSum(int[] nums, int target, int start, int end) {
        List<List<Integer>> res = new ArrayList<>();
        int l = start;
        int r = end;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                List<Integer> arr = new ArrayList<>();
                arr.add(nums[l]);
                arr.add(nums[r]);
                res.add(arr);
                while (l < end && nums[l] == nums[l + 1]) {
                    l++;
                }
                while (r > start && nums[r] == nums[r - 1]) {
                    r--;
                }
                l++;
                r--;
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            List<List<Integer>> twoSumRes = twoSum(nums, -nums[i], i + 1, nums.length - 1);
            for (int j = 0; j < twoSumRes.size(); j++) {
                List<Integer> arr = twoSumRes.get(j);
                arr.add(first);
                res.add(arr);
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return res;
    }
}
