package com.bigcow.cn.hot100;

public class Trap42Solution {

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }

    public static int trap(int[] height) {
        //第i处雨水的面积为， i 左边的最大值 lmax， i右边的最大值rmax， 体积 min(lmax, rmax)-height
        int[] dpLmax = new int[height.length];
        dpLmax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            dpLmax[i] = Math.max(dpLmax[i - 1], height[i]);
        }
        int[] dpRmax = new int[height.length];
        dpRmax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            dpRmax[i] = Math.max(dpRmax[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int temp = Math.min(dpLmax[i - 1], dpRmax[i + 1]) - height[i];
            res += temp > 0 ? temp : 0;
        }
        return res;
    }
}
