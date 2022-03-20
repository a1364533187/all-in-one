package com.bigcow.cn.code.bytedance.bfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22Solution {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, res, "", 0, 0);
        return res;
    }

    public static void dfs(int n, List<String> res, String path, int left, int right) {
        if (left == n && right == n) {
            res.add(path);
            return;
        }
        if (right > left || left > n || right > n) {
            return;
        }
        dfs(n, res, path + "(", left + 1, right);
        dfs(n, res, path + ")", left, right + 1);
    }
}
