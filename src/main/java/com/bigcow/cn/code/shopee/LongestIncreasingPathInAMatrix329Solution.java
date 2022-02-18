package com.bigcow.cn.code.shopee;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LongestIncreasingPathInAMatrix329Solution {

    public static void main(String[] args) {
        int[][] matrix =
                {{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};
        System.out.println(longestIncreasingPath(matrix));
    }

    // 回溯 + 记忆化
    public static int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, DFS(matrix, i, j));
            }

        }
        return max + 1;
    }

    /**
     * 记忆化
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    private static Map<Point, Integer> memory = new HashMap<>();

    private static int DFS(int[][] matrix, int i, int j) {
        Point p = new Point(i, j);
        if (memory.containsKey(p)) {
            return memory.get(p);
        }
        if (!isValid(matrix, i, j)) {
            memory.put(new Point(i, j), 0);
            return 0;
        }
        int var1 = 0;
        int var2 = 0;
        int var3 = 0;
        int var4 = 0;
        if (isValid(matrix, i - 1, j) && matrix[i][j] > matrix[i - 1][j]) {
            var1 = DFS(matrix, i - 1, j) + 1;
        }
        if (isValid(matrix, i + 1, j) && matrix[i][j] > matrix[i + 1][j]) {
            var2 = DFS(matrix, i + 1, j) + 1;
        }
        if (isValid(matrix, i, j - 1) && matrix[i][j] > matrix[i][j - 1]) {
            var3 = DFS(matrix, i, j - 1) + 1;
        }
        if (isValid(matrix, i, j + 1) && matrix[i][j] > matrix[i][j + 1]) {
            var4 = DFS(matrix, i, j + 1) + 1;
        }
        int max = Math.max(Math.max(Math.max(var1, var2), var3), var4);
        memory.put(p, max);
        return max;
    }

    private static boolean isValid(int[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }

    static class Point {

        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return i == point.i && j == point.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

}
