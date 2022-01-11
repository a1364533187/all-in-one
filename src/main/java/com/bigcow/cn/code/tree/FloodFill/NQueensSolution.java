package com.bigcow.cn.code.tree.FloodFill;

import java.util.ArrayList;
import java.util.List;

public class NQueensSolution {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        //        char[][] grid = { { '.', 'Q' }, { '.', '.' } };
        //        System.out.println(canPlaceQueue(grid, 2, 1, 0));
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrace(grid, n, res, -1, 0);
        return res;
    }

    private static void backtrace(char[][] grid, int n, List<List<String>> res, int depth,
            int queueCount) {
        if (depth == n - 1) {
            if (queueCount == n) {
                res.add(printGrid(grid, n));
            }
            return;
        }
        depth++;
        for (int i = 0; i < n; i++) {
            if (canPlaceQueue(grid, n, i, depth)) {
                grid[i][depth] = 'Q';
                backtrace(grid, n, res, depth, queueCount + 1);
                grid[i][depth] = '.';
            }
        }
    }

    private static List<String> printGrid(char[][] grid, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                row += grid[i][j];
            }
            res.add(row);
        }
        return res;
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
