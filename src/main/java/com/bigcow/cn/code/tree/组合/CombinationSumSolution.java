package com.bigcow.cn.code.tree.组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumSolution {

    public static void main(String[] args) {
        int[] nums = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum(nums, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        DFS(candidates, target, res, new LinkedList<>(), visited);
        return res;
    }

    public static void DFS(int[] candidates, int target, List<List<Integer>> res,
            LinkedList<Integer> path, boolean[] visited) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            /**
             * 如果当前元素值 小于 path中最大的元素，则不做选择，直接跳过防止重复情况！
             */
            if (path.size() > 0 && candidates[i] < path.get(path.size() - 1)) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.add(candidates[i]);
            DFS(candidates, target - candidates[i], res, path, visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}
