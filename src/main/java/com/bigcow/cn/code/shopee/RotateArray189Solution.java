package com.bigcow.cn.code.shopee;

public class RotateArray189Solution {

    public static void main(String[] args) {
        int[] nums = { -1 };
        rotate(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print("---" + nums[i]);
        }
    }

    /**
     * K 有可能超过nums.length
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        // 所有元素整体翻转
        reverse(nums, 0, nums.length - 1);
        // 翻转[0,k-1]前面的元素
        reverse(nums, 0, k - 1);
        // 翻转[k,nums.length - 1]前面的元素
        if (k < nums.length) {
            reverse(nums, k, nums.length - 1);
        }
    }

    // 数组翻转 --- 矩阵翻转 等等原地操作，双指针翻转
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

}
