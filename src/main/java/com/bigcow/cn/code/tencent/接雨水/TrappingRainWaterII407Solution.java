package com.bigcow.cn.code.tencent.接雨水;

public class TrappingRainWaterII407Solution {

    public static void main(String[] args) {
                int[][] heightMap = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
//        int[][] heightMap = { { 3, 3, 3, 3, 3 }, { 3, 2, 2, 2, 3 }, { 3, 2, 1, 2, 3 },
//                { 3, 2, 2, 2, 3 }, { 3, 3, 3, 3, 3 } };
        System.out.println(trapRainWater(heightMap));
    }

    /**
     * 一维的接雨水需要计算的是lmax, rmax
     * 二维的接雨水需要计算的是beforeMax, behindMax, 这里是不对的
     * @param heightMap
     * @return
     */
    public static int trapRainWater(int[][] heightMap) {
        int[][] lmaxMap = new int[heightMap.length][heightMap[0].length];
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j < heightMap[0].length; j++) {
                if (i > 0) {
                    lmaxMap[i][j] = Math.max(lmaxMap[i - 1][j], heightMap[i][j]);
                } else {
                    lmaxMap[i][j] = heightMap[i][j];
                }
            }
        }
        int[][] rmaxMap = new int[heightMap.length][heightMap[0].length];
        for (int i = heightMap.length - 1; i >= 0; i--) {
            for (int j = 0; j < heightMap[0].length; j++) {
                if (i < heightMap.length - 1) {
                    rmaxMap[i][j] = Math.max(rmaxMap[i + 1][j], heightMap[i][j]);
                } else {
                    rmaxMap[i][j] = heightMap[i][j];
                }
            }
        }
        int[][] beforeMaxMap = new int[heightMap.length][heightMap[0].length];
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j < heightMap[0].length; j++) {
                if (j > 0) {
                    beforeMaxMap[i][j] = Math.max(beforeMaxMap[i][j - 1], heightMap[i][j]);
                } else {
                    beforeMaxMap[i][j] = heightMap[i][j];
                }
            }
        }
        int[][] behindMaxMap = new int[heightMap.length][heightMap[0].length];
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = heightMap[0].length - 1; j >= 0; j--) {
                if (j < heightMap[0].length - 1) {
                    behindMaxMap[i][j] = Math.max(behindMaxMap[i][j + 1], heightMap[i][j]);
                } else {
                    behindMaxMap[i][j] = heightMap[i][j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j < heightMap[0].length; j++) {
                res += (findMinVal(lmaxMap[i][j], rmaxMap[i][j], beforeMaxMap[i][j],
                        behindMaxMap[i][j]) - heightMap[i][j]);
            }
        }
        return res;
    }

    private static int findMinVal(int var1, int var2, int var3, int var4) {
        return Math.min(Math.min(var1, var2), Math.min(var3, var4));
    }
}
