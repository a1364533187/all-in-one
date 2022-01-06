package com.bigcow.cn.code;

public class code {
    public static void main(String[] args) {
        int[] nums = {5,1,3};
        System.out.println(search(nums, 3));
    }

    // https://www.cnblogs.com/lfri/p/12553209.html
    //首先，一个重要的结论：将区间分均分，必然有一半有序，一半无序。问题是如何找到有序的那一半？
    // 注意：区间收缩时不包含 mid，也就是说，实际收缩后的区间是 [left,mid) 或者 (mid,right]
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
