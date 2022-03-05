package com.bigcow.cn.code.tencent.island;

public class NumberOfClosedIslands1254Solution {

    public static void main(String[] args) {
                int[][] grid = { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 },
                        { 1, 0, 1, 0, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 0 } };
//        int[][] grid = { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
        System.out.println(closedIsland(grid));
    }

    /**
     * grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
     * @param grid
     * @return
     */
    public static int closedIsland(int[][] grid) {
        // 统计符合条件的所有封闭岛屿
        int count = 0;
        // 如果只有一行或者一列那么无论如何都不会有封闭岛屿
        if (grid.length == 1 || grid[0].length == 1) {
            return count;
        }
        // 挨个去找所有符合条件的封闭岛屿，如果找到就将计数器加一
        // 因为四边出现的岛屿无论如何也不会是封闭岛屿，所以直接跳过他们的判断
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                // 如果当前是岛屿，那么就进行dfs判断，如果返回true就表示符合条件，反之不符合
                if (grid[i][j] == 0) {
                    if (traverse(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 可以访问到边界说明不是封闭岛屿
     * @param grid
     * @param x
     * @param y
     * @return
     */
    public static boolean traverse(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) { // 到达边界即不是岛屿
            return false;
        }
        if (grid[x][y] != 0) { // 访问到海洋，可以标记为
            return true;
        }
        grid[x][y] = 2;
        boolean var1 = traverse(grid, x + 1, y); // 上下左右都得访问到海洋
        boolean var2 = traverse(grid, x - 1, y);
        boolean var3 = traverse(grid, x, y - 1);
        boolean var4 = traverse(grid, x, y + 1);
        return var1 && var2 && var3 && var4;
    }
}
