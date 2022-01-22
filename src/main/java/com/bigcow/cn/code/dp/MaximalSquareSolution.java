package com.bigcow.cn.code.dp;

public class MaximalSquareSolution {

    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxEdge = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i >= 1 & j >= 1) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j])
                                + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                maxEdge = Math.max(dp[i][j], maxEdge);
            }
        }
        return maxEdge * maxEdge;
    }
}
