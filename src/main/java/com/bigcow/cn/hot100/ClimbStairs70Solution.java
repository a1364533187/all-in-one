package com.bigcow.cn.hot100;

public class ClimbStairs70Solution {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prev1 = 1;
        int prev2 = 2;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = prev1 + prev2;
            prev1 = prev2;
            prev2 = cur;
        }
        return cur;
    }
}
