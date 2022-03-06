package com.bigcow.cn.code.tencent;

import java.util.Arrays;
import java.util.Comparator;

public class ValidSquare593Solution {

    public static void main(String[] args) {
        //        int[] p1 = { 0, 0 }, p2 = { 1, 1 }, p3 = { 1, 0 }, p4 = { 0, 1 };
        //        int[] p1 = { 0, 0 }, p2 = { 1, 1 }, p3 = { 1, 0 }, p4 = { 0, 12 };
        int[] p1 = { 0, 0 }, p2 = { 5, 0 }, p3 = { 5, 4 }, p4 = { 0, 4 };
        System.out.println(validSquare(p1, p2, p3, p4));
    }

    /**
     * 先按照x坐标升序排， 排完后再按照
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] point4 = new int[4][2];
        point4[0] = p1;
        point4[1] = p2;
        point4[2] = p3;
        point4[3] = p4;
        Arrays.sort(point4, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        // 计算p0, p1 和 p0,p2相等且大于0， 并且直角
        // 计算p0, p4  == p0,p1 的根号2倍
        int distance1 = distanceSquare(point4[0], point4[1]);
        int distance2 = distanceSquare(point4[0], point4[2]);
        if (distance1 != distance2 || distance1 <= 0) {
            return false;
        }
        // 判断直角
        if (!isOrthogonal(point4[0], point4[1], point4[2])) {
            return false;
        }
        // 判断斜对角线
        int distance3 = distanceSquare(point4[0], point4[3]);
        return distance3 == distance1 + distance2;
    }

    private static int distanceSquare(int[] p1, int[] p2) {
        int a = p2[0] - p1[0];
        int b = p2[1] - p1[1];
        return a * a + b * b;
    }

    private static boolean isOrthogonal(int[] p0, int[] p1, int[] p2) {
        int[] p0p1 = new int[] { p1[0] - p0[0], p1[1] - p0[1] };
        int[] p0p2 = new int[] { p2[0] - p0[0], p2[1] - p0[1] };
        return p0p1[0] * p0p2[0] + p0p1[1] * p0p2[1] == 0;
    }
}
