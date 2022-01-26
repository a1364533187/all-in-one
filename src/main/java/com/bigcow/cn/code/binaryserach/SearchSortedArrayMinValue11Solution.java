package com.bigcow.cn.code.binaryserach;

public class SearchSortedArrayMinValue11Solution {

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        System.out.println(minArray(nums));
    }

    // 不用比较nums[start] 和 nums[end], 只需关注nums[0] 和 nums[length -1]
    // 比较只比较其中一个元素， 这里比较的是nums[length -1], 因为 1，3，5 这种缺德的情况
    public static int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            min = Math.min(numbers[mid], min);
            if (numbers[mid] < numbers[numbers.length - 1]) { // 右边角边有序
                end = mid - 1;
            } else if (numbers[mid] > numbers[numbers.length - 1]) { // 左边角有序
                start = mid + 1;
            } else { // 不明确递增关系，直接全遍历
                for (int i = start; i <= end; i++) {
                    min = Math.min(numbers[i], min);
                }
                return min;
            }
        }
        return min;
    }
}
