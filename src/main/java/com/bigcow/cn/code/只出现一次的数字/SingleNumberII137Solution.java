package com.bigcow.cn.code.只出现一次的数字;

import java.util.HashSet;

public class SingleNumberII137Solution {

    /**
     * 求和 + hashset
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        long setSum = 0;
        long numsSum = 0;
        for (int i = 0; i < nums.length; i++) {
            numsSum += nums[i];
            if (set.contains(nums[i])) {
                continue;
            }
            setSum += 1L * nums[i] * 3;
            set.add(nums[i]);
        }
        return (int) ((setSum - numsSum) / 2);
    }
}
