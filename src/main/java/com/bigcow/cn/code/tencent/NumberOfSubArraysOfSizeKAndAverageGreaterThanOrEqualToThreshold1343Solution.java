package com.bigcow.cn.code.tencent;

public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold1343Solution {

    public static void main(String[] args) {
        int[] arr = { 11,13,17,23,29,31,7,5,2,3 };
        int k = 3, threshold = 5;
        System.out.println(numOfSubarrays(arr, k, threshold));
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }
        int start = 0;
        int end = k - 1;
        int res = 0;
        int candidate = k * threshold;
        while (end < arr.length) {
            sum += arr[end];
            if (sum >= candidate) {
                res++;
            }
            sum -= arr[start];
            start++;
            end++;
        }
        return res;
    }
}
