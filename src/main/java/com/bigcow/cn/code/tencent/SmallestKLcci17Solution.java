package com.bigcow.cn.code.tencent;

public class SmallestKLcci17Solution {

    public static void main(String[] args) {
        int[] nums = { 3, 7, 1, 5, 7, 8, 10, 11 };
        quickSort(nums, 0, nums.length - 1, 2);

        for (int i = 0; i < nums.length; i++) {
            System.out.print("---" + nums[i]);
        }
    }

    public int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] newArr = new int[k];
        for (int i = 0; i < k; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    private static void quickSort(int[] arr, int start, int end, int k) {
        if (start > end) {
            return;
        }
        int mid = partition(arr, start, end);
        if (mid != k - 1) {
            quickSort(arr, start, mid - 1, k);
            quickSort(arr, mid + 1, end, k);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= pivot) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= pivot) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = pivot;
        return start;
    }
}
