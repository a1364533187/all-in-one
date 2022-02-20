package com.bigcow.cn.code.shopee;

import java.util.Arrays;

public class ValidTriangleNumber611Solution {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 4 };
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) { // 选第一个数
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isValid(nums, i, j, k)) {
                        count++;
                    }
                }
            }

        }
        return count;
    }

    public static boolean isValid(int[] nums, int first, int second, int third) {
        return nums[third] < nums[first] + nums[second];
    }

}
