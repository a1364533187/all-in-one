package com.bigcow.cn.code.众数;

public class MajorityElement169Solution {

    public static void main(String[] args) {
        int[] nums = { 8, 8, 7, 7, 7 };
        System.out.println(majorityElement(nums));
    }

    /**
     * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     * 摩尔投票法思路
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count > 0) {
                if (nums[i] == res) {
                    count++;
                } else {
                    count--;
                }
                continue;
            } else {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }
}
