package com.bigcow.cn.code.tree.FloodFill;

public class WordSolution {

    private static final int[][] DIRECTIONS = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(dfs(board, word, i, j,0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int depth, boolean[][] visited) {
        if (depth == word.length() - 1) {
            return board[x][y] == word.charAt(depth);
        }
        if (board[x][y] == word.charAt(depth)) {
            visited[x][y] = true;
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(board, newX, newY) && !visited[newX][newY]) {
                    if (dfs(board, word, newX, newY, depth + 1, visited)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
