package com.bigcow.cn.code.tree.组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombineSolution {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        DFS(n, k, res, new LinkedList<>(), 1);
        return res;
    }

    public static void DFS(int n, int k, List<List<Integer>> res, LinkedList<Integer> path,
            int begin) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.add(i);
            DFS(n, k, res, path, i + 1);
            path.removeLast();
        }
    }
}
