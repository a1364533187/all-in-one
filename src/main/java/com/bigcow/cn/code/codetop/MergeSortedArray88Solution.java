package com.bigcow.cn.code.codetop;

public class MergeSortedArray88Solution {

    public static void main(String[] args) {
        //        int[] nums1 = { 1, 2, 3, 4, 0, 0, 0 };
        //        int m = 4;
        //        int[] nums2 = { 2, 5, 6 };
        //        int n = 3;

        int[] nums1 = { 1, 2, 7, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;

        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print("---" + nums1[i]);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        while (index >= 0 && nums2Index >= 0) {
            if (nums1Index == -1) {
                // 把nums2的数全部复制过去
                for (int i = 0; i <= nums2Index; i++) {
                    nums1[i] = nums2[i];
                }
            } else {
                if (nums1[nums1Index] < nums2[nums2Index]) {
                    nums1[index] = nums2[nums2Index];
                    nums2Index--;
                } else {
                    // 原地swap
                    swap(nums1, nums1Index, index);
                    nums1Index--;
                }
            }
            index--;
        }
        return;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
