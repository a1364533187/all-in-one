package com.bigcow.cn.code.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZiFuChuanDePaiLieLcof38Solution {

    public static void main(String[] args) {
        String s = "abbc";
        String[] strs = permutation(s);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    public static String[] permutation(String s) {
        // 将s to array 并排序
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<String> res = new ArrayList<>();
        boolean[] visited = new boolean[s.length()];
        // DFS
        dfs(chars, res, "", visited);
        return res.toArray(new String[] {});
    }

    private static void dfs(char[] chars, List<String> res, String path, boolean[] visited) {
        if (path.length() == chars.length) {
            res.add(path);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            // 去重
            if (visited[i] || (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            dfs(chars, res, path + chars[i], visited);
            visited[i] = false;
        }
    }
}
