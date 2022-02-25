package com.bigcow.cn.hot100;

import java.util.Stack;

public class LargestRectangleArea84Solution {

    public static void main(String[] args) {
        int[] heights = { 2, 1, 2 };
        System.out.println(largestRectangleArea(heights));
    }

    // 单调栈的解法，妙啊
    // https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/
    // bilibili的视频： https://www.bilibili.com/video/BV1jV411S7WJ?p=1&share_medium=iphone&share_plat=ios&share_session_id=298FAEF7-1C0B-4AF9-B39C-0D41C6A93EA2&share_source=WEIXIN&share_tag=s_i&timestamp=1645769733&unique_k=1B8wEaR
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++)
            new_heights[i] = heights[i - 1];
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}
