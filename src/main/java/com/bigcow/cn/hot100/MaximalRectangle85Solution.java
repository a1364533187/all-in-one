package com.bigcow.cn.hot100;

import java.util.Stack;

public class MaximalRectangle85Solution {

    public static void main(String[] args) {
        //        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
        //                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };

        char[][] matrix = { { '0', '0', '1' }, { '1', '1', '1' } };
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        // 将一维的柱状图最大矩形， 转换为二维的最大矩形
        int[][] new_matrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < new_matrix.length; i++) {
            for (int j = 0; j < new_matrix[0].length; j++) {
                if (i == 0) {
                    if (matrix[i][j] == '1') {
                        new_matrix[i][j] = 1;
                    } else {
                        new_matrix[i][j] = 0;
                    }
                } else {
                    if (matrix[i][j] == '1') {
                        new_matrix[i][j] = new_matrix[i - 1][j] + 1;
                    } else {
                        new_matrix[i][j] = 0;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < new_matrix.length; i++) {
            max = Math.max(largestRectangleArea(new_matrix[i]), max);
        }
        return max;
    }

    // 单调栈的解法，妙啊, 84 与 85 是关联的
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
