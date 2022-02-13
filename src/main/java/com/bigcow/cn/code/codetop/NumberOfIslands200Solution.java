package com.bigcow.cn.code.codetop;

public class NumberOfIslands200Solution {

    static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    fill(grid, i, j);
                    print(grid);
                }
            }
        }
        return count;
    }

    private void print(char[][] grid) {
        System.out.println("-------");
        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
        }
    }

    // 类似于树的先序遍历
    private void fill(char[][] grid, int i, int j) {
        if (!isValid(grid, i, j) || grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }
        grid[i][j] = '2';
        for (int k = 0; k < direction.length; k++) {
            fill(grid, i + direction[k][0], j + direction[k][1]);
        }
    }

    private boolean isValid(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
