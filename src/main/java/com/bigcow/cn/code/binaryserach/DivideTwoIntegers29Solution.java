package com.bigcow.cn.code.binaryserach;

public class DivideTwoIntegers29Solution {

    public static void main(String[] args) {
        System.out.println(divide(-10, 1));
    }

    /**
     * 考虑到只能使用int,所以采用除数和被除数都为负数来计算，范围更大，采用减法模拟除法耗时大
     * https://leetcode-cn.com/problems/divide-two-integers/solution/gong-shui-san-xie-dui-xian-zhi-tiao-jian-utb9/
     * @param dividend
     * @param divisor
     * @return
     */
    //    public static int divide(int dividend, int divisor) {
    //        // 防止溢出
    //        if (dividend == Integer.MIN_VALUE && divisor == -1) {
    //            return Integer.MAX_VALUE;
    //        }
    //        if (dividend == 0) {
    //            return 0;
    //        }
    //        //采用减法模拟除法
    //        int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;
    //        // dividend 和 divisor 转换成正数来计算
    //        dividend = dividend > 0 ? -dividend : dividend;
    //        divisor = divisor > 0 ? -divisor : divisor;
    //        int res = 0;
    //        while (dividend <= divisor) {
    //            dividend -= divisor;
    //            res++;
    //        }
    //        return sign * res;
    //    }

    /**
     * 采用二分倍增法法试错，提升速度
     * https://blog.csdn.net/github_37382319/article/details/111833554
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        // 防止溢出
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        //采用减法模拟除法
        int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;
        // dividend 和 divisor 转换成正数来计算
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int res = 0;
        int baseTimes = 1;
        int shift = 0;
        while (dividend <= divisor) {
            int curTimes = baseTimes << shift;
            dividend -= divisor * curTimes;
            if (dividend <= 0) {
                res += curTimes;
                shift++;
            } else { // 小于0的话，继续从0开始移位
                dividend += divisor * curTimes;
                shift = 0;
            }
        }
        return sign * res;
    }
}
