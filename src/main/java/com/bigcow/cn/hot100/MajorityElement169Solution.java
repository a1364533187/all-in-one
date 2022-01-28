package com.bigcow.cn.hot100;

public class MajorityElement169Solution {

    public static void main(String[] args) {
        int[] nums = {6,5,5};
        System.out.println( majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (majorityElement == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    majorityElement = nums[i];
                    count = 1;
                }
                if (count > 0) {
                    count--;
                }

            }
        }
        return majorityElement;
    }
}
