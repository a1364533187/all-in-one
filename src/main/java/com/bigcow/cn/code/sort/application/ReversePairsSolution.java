package com.bigcow.cn.code.sort.application;

public class ReversePairsSolution {

    public static void main(String[] args) {
        int[] nums = { 1,3,2,3,1 };
//        int[] nums = { 7, 5, 6, 4 };
        int[] count = new int[1];
        mergeSort(nums, 0, nums.length - 1, count);
        for (int i = 0; i < nums.length; i++) {
            System.out.print("---" + nums[i]);
        }
        System.out.println();
        System.out.println(count[0]);
    }

    public int reversePairs(int[] nums) {
        int[] count = new int[1];
        mergeSort(nums, 0, nums.length - 1, count);
        return count[0];
    }

    private static void mergeSort(int[] nums, int start, int end, int[] count) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid, count);
        mergeSort(nums, mid + 1, end, count);
        merge(nums, start, end, mid, count);
    }

    private static void merge(int[] nums, int start, int end, int mid, int[] count) {
        int[] newArr = new int[end - start + 1];
        int newArrStart = 0;
        int startIndex = start;
        int endIndex = mid + 1;
        while (startIndex <= mid && endIndex <= end) {
            if (nums[startIndex] > nums[endIndex]) {
                count[0] += mid + 1 - startIndex;
//                count[0] += endIndex -mid; // 错误的原因[1,2,3], [1,3] 算出的结果是1，其实应该是2
                newArr[newArrStart] = nums[endIndex];
                newArrStart++;
                endIndex++;
            } else {
                newArr[newArrStart] = nums[startIndex];
                newArrStart++;
                startIndex++;
            }
        }

        while (startIndex <= mid) {
            newArr[newArrStart] = nums[startIndex];
            newArrStart++;
            startIndex++;
        }

        while (endIndex <= end) {
            newArr[newArrStart] = nums[endIndex];
            newArrStart++;
            endIndex++;
        }
        // 数组还原
        for (int i = start; i <= end; i++) {
            nums[i] = newArr[i - start];
        }
    }
}
