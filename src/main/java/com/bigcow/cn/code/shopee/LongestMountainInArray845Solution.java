package com.bigcow.cn.code.shopee;

public class LongestMountainInArray845Solution {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 7, 3, 2, 5 };

    }

    public static int longestMountain(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(spread(arr, i), res);
        }
        return res;
    }

    private static int spread(int[] arr, int center) {
        int left = center - 1;
        int right = center + 1;
        if (left < 0 || right >= arr.length
                || arr[left] >= arr[center] || arr[right] >= arr[center]) {
            return 0;
        }
        // 可以开始扩散了
        // 先扩散左边
        while (left - 1 >= 0 && arr[left - 1] < arr[left]) {
            left = left - 1;
        }
        // 再扩散右边
        while (right + 1 < arr.length && arr[right + 1] < arr[right]) {
            right = right + 1;
        }
        return right - left + 1;
    }
}
