package com.bigcow.cn.code.bytedance.bfs;

public class ContainerWithMostWater11Solution {

    public static void main(String[] args) {
        int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int curArea = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(maxArea, curArea);
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return maxArea;
    }
}
