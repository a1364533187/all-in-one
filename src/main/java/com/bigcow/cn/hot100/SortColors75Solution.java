package com.bigcow.cn.hot100;

public class SortColors75Solution {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("---" + nums[i]);
        }
    }

    public static void sortColors(int[] nums) {
        //第一趟 把0置换到开始的位置
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, index);
                index++;
            }
        }
        // 此时 0 已经置换到前面了
        //第二趟 把 1 置换到中间位置
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, index);
                index++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
