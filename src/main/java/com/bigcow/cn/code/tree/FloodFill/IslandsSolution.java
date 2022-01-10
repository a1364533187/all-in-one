package com.bigcow.cn.code.tree.FloodFill;

public class IslandsSolution {

    public int numIslands(char[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }
        // char[][] -> int[][]
        int[][] image = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    image[i][j] = 1;
                }
            }
        }
        int count = 1;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == 1) {
                    count++;
                    floodFill(image, i, j, count);
                }
            }
        }
        return count - 1;
    }

    static int[][] axis = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public void floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return;
        }
        int oldValue = image[sr][sc];
        freshColor(image, sr, sc, newColor, oldValue);
        return;
    }

    private void freshColor(int[][] image, int sr, int sc, int newColor, int oldValue) {
        image[sr][sc] = newColor;
        for (int i = 0; i < axis.length; i++) {
            int x = sr + axis[i][0];
            int y = sc + axis[i][1];
            if (x >= 0 && x < image.length && y >= 0 && y < image[0].length
                    && oldValue == image[x][y]) {
                freshColor(image, x, y, newColor, oldValue);
            }
        }
    }
}
