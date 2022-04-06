package com.bigcow.cn.code.sort;

public class ReversePairs51Solution {

    public static void main(String[] args) {
        int[] nums = { 7, 5, 6, 4 };
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        int[] count = new int[1];
        mergeSort(nums, 0, nums.length - 1, count);
        return count[0];
    }

    // 在mergeSort时，统计逆序对
    private static void mergeSort(int[] nums, int start, int end, int[] count) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid, count);
        mergeSort(nums, mid + 1, end, count);
        merge(nums, start, mid, end, count);
    }

    // [start, mid] 是有序的， [mid+1, end]是有序的
    private static void merge(int[] nums, int start, int mid, int end, int[] count) {
        int[] newArr = new int[end - start + 1];
        int curLeft = start;
        int curRight = mid + 1;
        int index = 0;
        while (curLeft <= mid && curRight <= end) {
            if (nums[curLeft] > nums[curRight]) {
                newArr[index] = nums[curRight];
                curRight++;
                count[0] += (mid - curLeft) + 1;
            } else {
                newArr[index] = nums[curLeft];
                curLeft++;
            }
            index++;
        }
        while (curLeft <= mid) {
            newArr[index] = nums[curLeft];
            curLeft++;
            index++;
        }
        while (curRight <= end) {
            newArr[index] = nums[curRight];
            curRight++;
            index++;
        }

        // 再将数组还原回去
        for (int i = start; i <= end; i++) {
            nums[i] = newArr[i - start];
        }
    }
}
