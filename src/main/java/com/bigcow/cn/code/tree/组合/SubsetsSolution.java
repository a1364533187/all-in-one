package com.bigcow.cn.code.tree.组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubsetsSolution {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(nums, 0, res, new LinkedList<>());
        return res;
    }

    private static void DFS(int[] nums, int start, List<List<Integer>> res,
            LinkedList<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            DFS(nums, i + 1, res, path); // i + 1 指的是纵向可选的节点
            path.removeLast();
        }
    }
}
