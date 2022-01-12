package com.bigcow.cn.code.other;

public class JosephRing {

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }

    // https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
    public static int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n - 1, m) + m) % n;
    }
}
