package com.bigcow.cn.code.shopee;

public class MaximumSwap670Solution {

    public static void main(String[] args) {
        int num = 9973;
        System.out.println(maximumSwap(num));
    }

    public static int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[][] rmax = new int[chars.length][2];
        rmax[chars.length - 1][0] = chars[chars.length - 1] - '0';
        rmax[chars.length - 1][1] = chars.length - 1;
        for (int i = chars.length - 2; i >= 0; i--) {
            int val = chars[i] - '0';
            if (val > rmax[i + 1][0]) {
                rmax[i][0] = val;
                rmax[i][1] = i;
            } else {
                rmax[i][0] = rmax[i + 1][0];
                rmax[i][1] = rmax[i + 1][1];
            }
        }
        for (int i = 0; i < chars.length - 1; i++) {
            int cur = chars[i] - '0';
            if (cur < rmax[i + 1][0]) {
                swap(chars, i, rmax[i + 1][1]);
                break;
            }
        }
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            res = res + chars[i];
        }
        return Integer.parseInt(res);
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

}
