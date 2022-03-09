package com.bigcow.cn.code.tree.组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII40Solution {

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        System.out.println(combinationSum2(candidates, 8));
    }

    /**
     * 对于每个树枝不能包含重复的， 可以用new hashset 来去重
     * 可以参考
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new LinkedList<>(), 0);
        return res;
    }

    private static void dfs(int[] candidates, int target, List<List<Integer>> res,
            LinkedList<Integer> path, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        /**
         * 树杈间有重复的采用new HashSet 来去重
         */
        HashSet<Integer> set = new HashSet<>();
        for (int i = begin; i < candidates.length; i++) {
            if (set.contains(candidates[i])) {
                continue;
            }
            if (target - candidates[i] < 0) {
                continue;
            }
            set.add(candidates[i]);
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], res, path, i + 1);
            path.removeLast();
        }
    }
}
