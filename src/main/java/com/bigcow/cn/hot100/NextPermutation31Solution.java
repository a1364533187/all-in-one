package com.bigcow.cn.hot100;

public class NextPermutation31Solution {

    public static void main(String[] args) {
        int[] nums = { 3,2,1 };
        nextPermutation(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print("---" + nums[i]);
        }
    }

    public static void nextPermutation(int[] nums) {
        // 从后往前看， 找到升序序列首个降序的数字
        int cur = nums.length - 1;
        while (cur > 0 && nums[cur] <= nums[cur - 1]) {
            cur--;
        }
        int swapNums1Index = cur - 1;
        if (swapNums1Index == -1) { // 说明从后往前看都是升序序列， 是最大字典序
            reverseNums(nums, 0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[swapNums1Index]) {
                swap(nums, i, swapNums1Index);
                break;
            }
        }
        reverseNums(nums, swapNums1Index + 1, nums.length - 1);
    }

    private static void reverseNums(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
