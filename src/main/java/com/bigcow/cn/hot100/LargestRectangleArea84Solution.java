package com.bigcow.cn.hot100;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleArea84Solution {

    public static void main(String[] args) {
        int[] heights = { 2, 1,2 };
        System.out.println(largestRectangleArea(heights));
    }

    // 单调栈的解法，妙啊
    // https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) new_heights[i] = heights[i - 1];
        System.out.println(Arrays.toString(new_heights));
        for (int i = 0; i < new_heights.length; i++) {
            //System.out.println(stack.toString());
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}
