package com.bigcow.cn.code.tencent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences491Solution {

    /**
     * 代码随想录： https://leetcode-cn.com/problems/increasing-subsequences/solution/491-di-zeng-zi-xu-lie-shen-sou-hui-su-xiang-jie-by/
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = { 4, 6, 7, 7 };
        System.out.println(findSubsequences(nums));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new LinkedList<>(), 0);
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, LinkedList<Integer> path,
            int begin) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }

        /**
         * 每层树杈增加上Set, 来去重， 对于重复的场景
         */
        Set<Integer> set = new HashSet<>();
        for (int i = begin; i < nums.length; i++) {
            // 去重
            if (!path.isEmpty() && nums[i] < path.getLast() || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            dfs(nums, res, path, i + 1);
            path.removeLast();
        }
    }
}
