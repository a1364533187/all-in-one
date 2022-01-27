package com.bigcow.cn.hot100;

public class SearchRange34Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // 找起始位置和结束位置
                int left = mid;
                while (left > 0) {
                    left--;
                    if (nums[left] != target) {
                        left = left + 1;
                        break;
                    }
                }
                int right = mid; //右侧找
                while (right < nums.length - 1) {
                    right++;
                    if (nums[right] != target) {
                        right = right - 1;
                        break;
                    }
                }
                return new int[] { left, right };

            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }
}
