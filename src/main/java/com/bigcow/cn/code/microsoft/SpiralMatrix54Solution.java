package com.bigcow.cn.code.microsoft;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54Solution {

    public static void main(String[] args) {
        //        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int i = 0, j = 0;
        while (i >= top && i <= bottom && j >= left && j <= right) {
            // 往右走
            while (j <= right && left <= right && top <= bottom) {
                res.add(matrix[i][j++]);
            }
            j--;
            top++;
            i++;

            // 往下走
            while (i <= bottom && left <= right && top <= bottom) {
                res.add(matrix[i++][j]);
            }
            i--;
            right--;
            j--;

            // 往左走
            while (j >= left  && left <= right && top <= bottom) {
                res.add(matrix[i][j--]);
            }
            j++;
            bottom--;
            i--;

            // 往上走
            while (i >= top  && left <= right && top <= bottom) {
                res.add(matrix[i--][j]);
            }
            i++;
            left++;
            j++;
        }
        return res;
    }
}
