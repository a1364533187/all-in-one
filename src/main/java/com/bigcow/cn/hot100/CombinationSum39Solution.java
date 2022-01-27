package com.bigcow.cn.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum39Solution {

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        System.out.println(combinationSum(nums, 7));
    }

    /**
     * https://leetcode-cn.com/problems/combination-sum/solution/shou-hua-tu-jie-zu-he-zong-he-combination-sum-by-x/
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(candidates, target, res, new LinkedList<>(), 0);
        return res;
    }

    private static void DFS(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> path, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) { // 如何去重剪枝呢？
            path.add(candidates[i]);
            DFS(candidates, target - candidates[i], res, path, i);
            path.removeLast();
        }
    }
}
