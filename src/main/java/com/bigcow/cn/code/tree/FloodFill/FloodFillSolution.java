package com.bigcow.cn.code.tree.FloodFill;

public class FloodFillSolution {

    static int[][] axis = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        int oldValue = image[sr][sc];
        freshColor(image, sr, sc, newColor, oldValue);
        return image;
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
