package com.bigcow.cn.code.tree.FloodFill;

public class WordSolution1 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (DFS(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean DFS(char[][] board, String word, int depth, int i, int j, boolean[][] visited) {
        if (depth == word.length()) {
            return true;
        }
        char curChar = word.charAt(depth);
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            if (!visited[i][j] && curChar == board[i][j]) {
                visited[i][j] = true;
                boolean res = DFS(board, word, depth + 1, i + 1, j, visited)
                        || DFS(board, word, depth + 1, i - 1, j, visited)
                        || DFS(board, word, depth + 1, i, j + 1, visited)
                        || DFS(board, word, depth + 1, i, j - 1, visited);
                visited[i][j] = false;
                return res;
            }
        }
        return false;
    }
}
