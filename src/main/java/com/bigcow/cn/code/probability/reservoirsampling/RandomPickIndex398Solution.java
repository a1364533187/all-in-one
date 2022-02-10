package com.bigcow.cn.code.probability.reservoirsampling;

import java.util.Random;

public class RandomPickIndex398Solution {

    private int[] nums;

    public RandomPickIndex398Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random random = new Random();
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                n++;
                if (random.nextInt(n) == 0) {
                    return i;
                }
            }
        }
        return 0;
    }
}
