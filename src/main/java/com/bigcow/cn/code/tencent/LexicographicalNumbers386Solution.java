package com.bigcow.cn.code.tencent;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers386Solution {

    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
    }

    /**
     * 经典的思路
     * https://leetcode-cn.com/problems/lexicographical-numbers/solution/java-zi-dian-xu-de-bian-li-by-ppppjqute/
     * @param n
     * @return
     */
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, res, i);
        }
        return res;
    }

    private static void dfs(int n, List<Integer> res, int i) {
        if (i > n) {
            return;
        }
        res.add(i);
        for (int j = 0; j < 10; j++) {
            dfs(n, res, 10 * i + j);
        }
    }
}
