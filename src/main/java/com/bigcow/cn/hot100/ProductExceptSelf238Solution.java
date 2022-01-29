package com.bigcow.cn.hot100;

public class ProductExceptSelf238Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] positiveDp = new int[nums.length];
        int[] reverseDp = new int[nums.length];
        // 正向
        positiveDp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            positiveDp[i] = positiveDp[i - 1] * nums[i - 1];
        }
        reverseDp[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            reverseDp[i] = reverseDp[i + 1] * nums[i + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = positiveDp[i] * reverseDp[i];
        }
        return res;
    }
}
