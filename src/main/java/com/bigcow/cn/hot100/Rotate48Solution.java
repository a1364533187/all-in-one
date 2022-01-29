package com.bigcow.cn.hot100;

public class Rotate48Solution {
    // 顺时针旋转90
    // 顺时针旋转90
    public void rotate(int[][] matrix) {
        // 原理就是：沿着中心点对折 1、先沿对角线对折，2、再沿垂直平分线对折, 可以画(x,y) 基向量来判断
        // 先沿对角线对折
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        int mid = (matrix.length - 1) / 2;
        // 再沿垂直平分线对折
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= mid; j++) {
                swap(matrix, i, j, i, matrix[0].length - j - 1);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int m, int n) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }
}
