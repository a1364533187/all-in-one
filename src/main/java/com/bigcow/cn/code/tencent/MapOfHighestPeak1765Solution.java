package com.bigcow.cn.code.tencent;

import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak1765Solution {

    public static int[][] highestPeak(int[][] isWater) {
        maxDistance(isWater);
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                isWater[i][j] = isWater[i][j] - 1;
            }
        }
        return isWater;
    }

    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    // BFS 将1加入到队列， 层序遍历，遍历过程记录最大的Distance
    // https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/jian-dan-java-miao-dong-tu-de-bfs-by-sweetiee/
    public static int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] { i, j });
                }
            }
        }
        int maxDisTance = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (!isValidPoint(grid, newX, newY) || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1;
                maxDisTance = Math.max(maxDisTance, grid[newX][newY]);
                queue.add(new int[] { newX, newY });
            }
        }
        return maxDisTance - 1;
    }

    private static boolean isValidPoint(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
