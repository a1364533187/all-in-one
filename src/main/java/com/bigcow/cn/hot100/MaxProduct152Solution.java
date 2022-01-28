package com.bigcow.cn.hot100;

public class MaxProduct152Solution {

    public int maxProduct(int[] nums) {
        int[] maxDp = new int[nums.length]; // 存放当前位置的最大值
        Integer[] negativeDp = new Integer[nums.length];
        maxDp[0] = nums[0];
        if (nums[0] < 0) {
            negativeDp[0] = nums[0];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int product1 = nums[i] * maxDp[i - 1];
            if (null != negativeDp[i - 1]) {
                int product2 = nums[i] * negativeDp[i - 1];
                maxDp[i] = Math.max(Math.max(nums[i], product1), product2);
                int min = Math.min(Math.min(product1, product2), nums[i]);
                if (min < 0) {
                    negativeDp[i] = min;
                }
            } else {
                maxDp[i] = Math.max(nums[i], product1);
                int min = Math.min(nums[i], product1);
                if (min < 0) {
                    negativeDp[i] = min;
                }
            }
            max = Math.max(maxDp[i], max);
        }
        return max;
    }

}
