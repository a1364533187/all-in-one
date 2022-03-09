package com.bigcow.cn.code.microsoft;

public class SurroundedRegions130Solution {

    public static void main(String[] args) {
        //        char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
        //                { 'X', 'O', 'X', 'X' } };
        char[][] board = { { 'O', 'X', 'O' }, { 'X', 'O', 'X' }, { 'O', 'X', 'O' } };
        solve(board);
    }

    public static void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    if (fill(board, i, j)) {
                        // 将所有的Y 替换成X
                        fresh(board, 'Y', 'X');
                    } else {
                        fresh(board, 'Y', 'Z');
                    }
                }
            }
        }

        // 将所有'Z' -> 'O'
        fresh(board, 'Z', 'O');
    }

    private static void fresh(char[][] board, char oldChar, char newChar) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == oldChar) {
                    board[i][j] = newChar;
                }
            }
        }
    }

    /**
     * 遍历 'O' 修改为 'Y', 并判断是否是岛屿，不是的话，返回false
     * @param board
     * @return
     */
    private static boolean fill(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != 'O') {
            return true;
        }
        board[i][j] = 'Y';
        boolean up = fill(board, i - 1, j);
        boolean down = fill(board, i + 1, j);
        boolean left = fill(board, i, j - 1);
        boolean right = fill(board, i, j + 1);
        return up && down && left && right;
    }
}
