package com.bigcow.cn.code.number;

public class PalindromeNumber9Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        // x >0 ， 如果res 溢出了结果肯定是不等的
        int rev = reverse(x);
        return rev == x;
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
            res = res * 10 + digit;
            x = x / 10;
        }
        return res;
    }
}
