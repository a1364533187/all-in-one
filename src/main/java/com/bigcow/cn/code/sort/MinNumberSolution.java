package com.bigcow.cn.code.sort;

// 把数组中的元素排成最小的数
public class MinNumberSolution {

    // https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
    // 此题求拼接起来的最小数字，本质上是一个排序问题。设数组 numsnums 中任意两数字的字符串为 xx 和 yy ，则规定 排序判断规则 为：
    //
    //若拼接字符串 x + y > y + x ，则 x “大于” y ；
    //反之，若 x + y < y + x，则 x “小于” y ；
    public String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(nums, start, end);
        quickSort(nums, start, mid - 1);
        quickSort(nums, mid + 1, end);
    }

    //用快排
    public static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            // 比较改造
            while (start < end && isGreaterThanEqual(nums[end], pivot)) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && isSmallerThanEqual(nums[start], pivot)) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    private static boolean isGreaterThanEqual(int x, int y) {
        String xy = x + "" + y;
        String yx = y + "" + x;

        int value = xy.compareTo(yx);
        return value >= 0;
    }

    private static boolean isSmallerThanEqual(int x, int y) {
        String xy = x + "" + y;
        String yx = y + "" + x;

        int value = xy.compareTo(yx);
        return value <= 0;
    }
}
