package com.bigcow.cn.code.tencent.island;

public class MaxAreaOfIsland105Solution {

    public static void main(String[] args) {
//        int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
//                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
//                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
//                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
//                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
//                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
//                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
//                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
        int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 如果当前是岛屿，那么就进行dfs判断，如果返回true就表示符合条件，反之不符合
                if (grid[i][j] == 1) {
                    int[] count = new int[1];
                    traverse(grid, i, j, count);
                    maxCount = Math.max(maxCount, count[0]);
                }
            }
        }
        return maxCount;
    }

    private static void traverse(int[][] grid, int i, int j, int[] count) {
        if (!isValidPoint(grid, i, j) || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        count[0]++;
        traverse(grid, i + 1, j, count);
        traverse(grid, i - 1, j, count);
        traverse(grid, i, j - 1, count);
        traverse(grid, i, j + 1, count);
    }

    private static boolean isValidPoint(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
