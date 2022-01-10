package com.bigcow.cn.code.tree.FloodFill;

public class AroundAreaSolution {

    public void solve(char[][] board) {
        //从边缘扫描，将相邻的'0' -> 'Y'， 知道所有的的都改完
        // 改完后， 将剩余的'0' -> 'X'
        // 最后， 将 'Y' -> '0', 完成
        /**
         * x = 0 或者 x = board.length - 1
         */
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                floodFill(board, 0, j, 'Y');
            }
            if (board[board.length - 1][j] == 'O') {
                floodFill(board, board.length - 1, j, 'Y');
            }
        }

        /**
         * y = 0 或者 y = board[0].length - 1
         */
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                floodFill(board, i, 0, 'Y');
            }
            if (board[i][board[0].length - 1] == 'O') {
                floodFill(board, i, board[0].length - 1, 'Y');
            }
        }

        //修改完之后， 将剩余的'0' -> 'X'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        // 最后还原 'Y' -> '0'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    static int[][] axis = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public char[][] floodFill(char[][] image, int sr, int sc, char newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        char oldValue = image[sr][sc];
        freshColor(image, sr, sc, newColor, oldValue);
        return image;
    }

    private void freshColor(char[][] image, int sr, int sc, char newColor, char oldValue) {
        image[sr][sc] = newColor;
        for (int i = 0; i < axis.length; i++) {
            int x = sr + axis[i][0];
            int y = sc + axis[i][1];
            if (x >= 0 && x < image.length && y >= 0 && y < image[0].length
                    && oldValue == image[x][y]) {
                freshColor(image, x, y, newColor, oldValue);
            }

        }
    }
}
