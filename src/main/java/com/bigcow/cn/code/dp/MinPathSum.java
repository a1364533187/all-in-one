package com.bigcow.cn.code.dp;

public class MinPathSum {

    // 1 <= m, n <= 200
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return minPathSum(grid, m, n);
    }

    // dp[i][j] == min(dp[i-1][j], dp[i][j-1]) +  grid[i][j]
    public int minPathSum(int[][] grid, int m, int n) {
        int[][] minSums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    minSums[i][j] = grid[i][j];
                } else if (i == 0) {
                    minSums[i][j] = minSums[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    minSums[i][j] = minSums[i - 1][j] + grid[i][j];
                } else {
                    minSums[i][j] = Math.min(minSums[i - 1][j], minSums[i][j - 1]) + grid[i][j];
                }
            }
        }
        return minSums[m - 1][n - 1];
    }
}
