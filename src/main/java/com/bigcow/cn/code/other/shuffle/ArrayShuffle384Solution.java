package com.bigcow.cn.code.other.shuffle;

import java.util.Arrays;
import java.util.Random;

public class ArrayShuffle384Solution {

    private int[] source;
    private int[] nums;

    public ArrayShuffle384Solution(int[] nums) {
        this.nums = nums;
        source = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        this.nums = source;
        return nums;
    }

    /**
     * https://leetcode-cn.com/u/wfnuser/
     * @return
     */
    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int random = i + new Random().nextInt(nums.length - i);
            swap(nums, i, random);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
