package com.bigcow.cn.code.sort.onlytest;

public class SortAnArray912Solution {

    public static void main(String[] args) {
        int[] nums = { 1, 5, 3, 2, 7 };
        sortArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    public static void sortArray(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(nums, start, end);
        sortArray(nums, start, mid - 1);
        sortArray(nums, mid + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {

        int pivot = nums[start];
        while (start < end) {
            while (start < end && pivot <= nums[end]) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && pivot >= nums[start]) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }
}
