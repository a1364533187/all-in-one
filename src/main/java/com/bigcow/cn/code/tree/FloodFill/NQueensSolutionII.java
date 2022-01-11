package com.bigcow.cn.code.tree.FloodFill;

public class NQueensSolutionII {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        //        char[][] grid = { { '.', 'Q' }, { '.', '.' } };
        //        System.out.println(canPlaceQueue(grid, 2, 1, 0));
    }

    public static int solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        int[] resCount = { 0 };
        backtrace(grid, n, -1, 0, resCount);
        return resCount[0];
    }

    private static void backtrace(char[][] grid, int n, int depth, int queueCount, int[] resCount) {
        if (depth == n - 1) {
            if (queueCount == n) {
                resCount[0]++;
            }
            return;
        }
        depth++;
        for (int i = 0; i < n; i++) {
            if (canPlaceQueue(grid, n, i, depth)) {
                grid[i][depth] = 'Q';
                backtrace(grid, n, depth, queueCount + 1, resCount);
                grid[i][depth] = '.';
            }
        }
    }

    //校验是否该位置可以放置皇后
    private static boolean canPlaceQueue(char[][] grid, int n, int i, int j) {
        //横向判断
        for (int k = 0; k < n; k++) {
            if (grid[i][k] == 'Q') {
                return false;
            }
        }
        //纵向判断
        for (int k = 0; k < n; k++) {
            if (grid[k][j] == 'Q') {
                return false;
            }
        }
        //西北
        int start = i;
        int end = j;
        while (start >= 0 && end >= 0) {
            start--;
            end--;
            if (start >= 0 && end >= 0 && grid[start][end] == 'Q') {
                return false;
            }
        }

        //东南
        start = i;
        end = j;
        while (start < n && end < n) {
            start++;
            end++;
            if (start < n && end < n && grid[start][end] == 'Q') {
                return false;
            }
        }

        //东北
        start = i;
        end = j;
        while (start < n && end >= 0) {
            start++;
            end--;
            if (start < n && end >= 0 && grid[start][end] == 'Q') {
                return false;
            }
        }

        //西南
        start = i;
        end = j;
        while (start >= 0 && end < n) {
            start--;
            end++;
            if (start >= 0 && end < n && grid[start][end] == 'Q') {
                return false;
            }
        }

        return true;

    }
}
