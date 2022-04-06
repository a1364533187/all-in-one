package com.bigcow.cn.code.binaryserach;

public class Sqrtx69Solution {

    public static void main(String[] args) {
        //        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }

    //    public static int mySqrt(int x) {
    //        if (x == 0 || x == 1) {
    //            return x;
    //        }
    //        int start = 1, end = x / 2;
    //        while (start < end) {
    //            int mid = start + (end - start) / 2;
    //            if (mid == x / mid) {
    //                return mid;
    //            } else if (mid < x / mid) {
    //                start = mid + 1;
    //            } else {
    //                end = mid - 1;
    //            }
    //        }
    //        if (start > x / start) {
    //            return start - 1;
    //        }
    //        return start;
    //    }

    // 牛顿迭代法
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int a = x;
        return (int) niudunIterator(x, a);
    }

    public static double niudunIterator(double x, int a) {
        double res = (x + a / x) / 2;
        if (x == res) {
            return res;
        } else {
            return niudunIterator(res, a);
        }
    }

}
