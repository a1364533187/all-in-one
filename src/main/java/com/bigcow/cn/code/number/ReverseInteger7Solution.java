package com.bigcow.cn.code.number;

public class ReverseInteger7Solution {

    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * 注意边界的溢出, 提前计算Res
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            // MAX_VALUE 是否会越界
            if (digit >= 0 && (Integer.MAX_VALUE - digit) / 10 < res) {
                return 0;
            }
            // 判断MIN_VALUE 是否会越界
            if (digit <= 0 && (Integer.MIN_VALUE - digit) / 10 > res) {
                return 0;
            }
            res = res * 10 + digit;
            x = x / 10;
        }
        return res;
    }
}
