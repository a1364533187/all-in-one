package com.bigcow.cn.code.shopee;

public class IncreasingTripletSubsequence334Solution {

    public static void main(String[] args) {
        int[] nums = { 2, 1, 5, 0, 4, 6 };
        System.out.println(increasingTriplet(nums));
    }

    /**
     * 找左边rmin , 找右边rmax
     * nums[i] 在rmin 和 rmax 之间，则符合预期
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums) {
        int[] rmin = new int[nums.length];
        rmin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            rmin[i] = nums[i] < rmin[i - 1] ? nums[i] : rmin[i - 1];
        }
        int[] rmax = new int[nums.length];
        rmax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rmax[i] = nums[i] > rmax[i + 1] ? nums[i] : rmax[i + 1];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > rmin[i] && nums[i] < rmax[i]) {
                return true;
            }
        }
        return false;
    }
}
