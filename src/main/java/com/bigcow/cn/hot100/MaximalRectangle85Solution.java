package com.bigcow.cn.hot100;

public class MaximalRectangle85Solution {

    public static void main(String[] args) {
        //        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
        //                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };

        char[][] matrix = { { '0', '0', '1' }, { '1', '1', '1' } };
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        // 统计单行最大的1的个数
        int maxRow = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] dpRow = new int[matrix[0].length];
            if (matrix[i][0] == '1') {
                dpRow[0] = 1;
                maxRow = 1;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dpRow[j] = dpRow[j - 1] + 1;
                } else {
                    dpRow[j] = 0;
                }
                maxRow = Math.max(dpRow[j], maxRow);
            }
        }
        // 统计单列最大的1的个数
        int maxCol = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            int[] dpCol = new int[matrix.length];
            if (matrix[0][j] == '1') {
                dpCol[0] = 1;
                maxCol = 1;
            }
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] == '1') {
                    dpCol[i] = dpCol[i - 1] + 1;
                } else {
                    dpCol[i] = 0;
                }
                maxCol = Math.max(dpCol[i], maxCol);
            }
        }

        int res = Math.max(maxCol, maxRow);

        // 统计多行最大的矩阵
        // 1、先改写矩阵， 1左右有0的，置为0， 上下有0的置为0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && i + 1 < matrix.length && matrix[i - 1][j] == '0'
                        && matrix[i + 1][j] == '0') {
                    matrix[i][j] = '0';
                }
                if (j > 0 && j + 1 < matrix[0].length && matrix[i][j - 1] == '0'
                        && matrix[i][j + 1] == '0') {
                    matrix[i][j] = '0';
                }
            }
        }

        // 再将冒尖的首行/首列， 尾行/尾列 1置为0
        for (int i = 0; i < matrix.length; i++) {
            //j == 0
            if (matrix[0].length > 1 && matrix[i][1] == '0') {
                matrix[i][0] = '0';
            }
            // j == matrix[0].length - 1;
            if (matrix[0].length > 1 && matrix[i][matrix[0].length - 2] == '0') {
                matrix[i][matrix[0].length - 1] = '0';
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            //i == 0
            if (matrix.length > 1 && matrix[1][j] == '0') {
                matrix[0][j] = '0';
            }
            // i == matrix.length - 1;
            if (matrix.length > 1 && matrix[matrix.length - 2][j] == '0') {
                matrix[matrix.length - 1][j] = '0';
            }
        }
        // 最后DFS 遍历没有改写好的矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int[] count = new int[1];
                    DFS(matrix, i, j, count);
                    res = Math.max(res, count[0]);
                }
            }
        }
        return res;
    }

    private static void DFS(char[][] matrix, int i, int j, int[] count) {
        if (!isValid(matrix, i, j) || matrix[i][j] == '0' || matrix[i][j] == '2') {
            return;
        }
        if (matrix[i][j] == '1') {
            count[0]++;
            matrix[i][j] = '2';
        }
        DFS(matrix, i - 1, j, count);
        DFS(matrix, i + 1, j, count);
        DFS(matrix, i, j - 1, count);
        DFS(matrix, i, j + 1, count);
    }

    private static boolean isValid(char[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
