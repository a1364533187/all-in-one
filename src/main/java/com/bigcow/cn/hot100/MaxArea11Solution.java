package com.bigcow.cn.hot100;

public class MaxArea11Solution {

    //https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            // 取决于短板,并移动短板
            if (height[i] > height[j]) {
                int area = height[j] * (j - i);
                maxArea = Math.max(area, maxArea);
                j--;
            } else {
                int area = height[i] * (j - i);
                maxArea = Math.max(area, maxArea);
                i++;
            }
        }
        return maxArea;
    }
}
