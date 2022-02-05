package com.bigcow.cn.hot100;

public class SearchMatrix240Solution {

    /**
     * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-4/
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            int cur = matrix[i][j];
            if (target > cur) {
                i++;
            } else if (target < cur) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
