package com.bigcow.cn.hot100;

public class HammingDistance461Solution {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    //    public static int hammingDistance(int x, int y) {
    //        int var = x ^ y;
    //        int res = 0;
    //        while (var != 0) {
    //            res += (var & 1);
    //            var = (var >> 1);
    //        }
    //        return res;
    //    }

    public static int hammingDistance(int x, int y) {
        int var = x ^ y;
        int res = 0;
        while (var != 0) {
            var = var & (var - 1); // 每循环一次，ss 都会删去其二进制表示中最右侧的 11
            res++;
        }
        return res;
    }
}
