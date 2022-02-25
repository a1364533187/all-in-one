package com.bigcow.cn.code.shopee;

public class MaxConsecutiveOnesIII1004Solution {

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        System.out.println(longestOnes(nums, 3));
    }

    /**
     * 滑动窗口题，窗口内最多K个0
     * @param nums
     * @param k
     * @return
     */
    public static int longestOnes(int[] nums, int k) {
        int res = 0;
        int start = 0;
        int end = 0;
        int count0 = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                count0++;
            }
            while (count0 > k) { // shrink window
                if (nums[start] == 0) {
                    count0--;
                }
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
