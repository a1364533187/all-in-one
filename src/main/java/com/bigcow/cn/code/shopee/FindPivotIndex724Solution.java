package com.bigcow.cn.code.shopee;

public class FindPivotIndex724Solution {

    public static void main(String[] args) {
        int[] nums = {2,1,-1};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int[] lPersum = new int[nums.length+1];
        lPersum[0] = 0;
        for (int i = 1; i < lPersum.length; i++) {
            lPersum[i] = lPersum[i-1] + nums[i-1];
        }
        int[] rPersum = new int[nums.length+1];
        rPersum[nums.length] = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            rPersum[i] = rPersum[i+1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (lPersum[i] == rPersum[i+1]) {
                return i;
            }
        }
        return -1;
    }
}
