package com.bigcow.cn.code.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {1,7,4,2,5};
        mergeSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void mergeSort(int[] nums) {
        if (nums.length <= 0) {
            return;
        }
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, end, mid);
    }

    public static void merge(int[] nums, int start, int end, int mid) {
        int[] sortArr = new int[end - start + 1];
        int sortIndex = 0;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (nums[left] >= nums[right]) {
                sortArr[sortIndex] = nums[right];
                right++;
            } else {
                sortArr[sortIndex] = nums[left];
                left++;
            }
            sortIndex++;
        }

        while (left <= mid) {
            sortArr[sortIndex] = nums[left];
            left++;
            sortIndex++;
        }
        while (right <= end) {
            sortArr[sortIndex] = nums[right];
            right++;
            sortIndex++;
        }
        // 最后还原回去
        sortIndex = 0;
        for (int i = start; i <= end; i++) {
            nums[i] = sortArr[sortIndex];
            sortIndex++;
        }
    }
}
