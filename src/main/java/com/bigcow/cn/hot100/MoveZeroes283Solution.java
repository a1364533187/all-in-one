package com.bigcow.cn.hot100;

public class MoveZeroes283Solution {

    public static void main(String[] args) {
        int[] nums = {3,1,0,3,0,12};
        moveZeroes(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print("---" + nums[i]);
        }
    }

    public static void moveZeroes(int[] nums) {
        //遍历数组， 将非0和 index 位置元素交换
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, index);
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
