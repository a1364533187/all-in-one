package com.bigcow.cn.code.shopee;

public class JuZhenZhongDeLuJingLcof12Solution {

    public static void main(String[] args) {
        //        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        char[][] board = { { 'a', 'b' }, { 'c', 'd' } };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, boolean[][] visited,
            int index) {
        if (index == word.length()) {
            return true;
        }
        char c = word.charAt(index);
        if (!isValid(board, i, j) || c != board[i][j] || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(board, word, i + 1, j, visited, index + 1)
                || dfs(board, word, i - 1, j, visited, index + 1)
                || dfs(board, word, i, j - 1, visited, index + 1)
                || dfs(board, word, i, j + 1, visited, index + 1);
        visited[i][j] = false;
        return res;
    }

    private static boolean isValid(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
