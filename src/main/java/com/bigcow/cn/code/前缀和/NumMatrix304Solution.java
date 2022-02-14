package com.bigcow.cn.code.前缀和;

public class NumMatrix304Solution {

    private int[][] perSumMatrix;

    public NumMatrix304Solution(int[][] matrix) {
        this.perSumMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    perSumMatrix[i][0] = matrix[i][0];
                } else {
                    perSumMatrix[i][j] = perSumMatrix[i][j - 1] + matrix[i][j];
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("--" + perSumMatrix[i][j]);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum = sum + (col1 == 0 ? perSumMatrix[i][col2] : perSumMatrix[i][col2]
                    - perSumMatrix[i][col1 - 1]);
        }
        return sum;
    }
}
