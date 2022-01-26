package com.bigcow.cn.code.binaryserach;

public class SearchSortedArray33Solution {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) { //这里为什么是<=
            int mid = start + (end - start) / 2; // 避免start + end 溢出
            if (nums[mid] == target) {
                return mid;
            }
            // 不用比较nums[start] 和 nums[end], 只需关注nums[0] 和 nums[length -1]
            // 比较只比较其中一个元素
            if (nums[mid] >= nums[0]) { // 第一段最前段有序， 比较nums[0]
                if (nums[0] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) { // 第二段最后段有序
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
