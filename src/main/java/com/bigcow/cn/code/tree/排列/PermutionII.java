package com.bigcow.cn.code.tree.排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutionII {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        //[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        DFS(nums, res, new LinkedList<>(), visited, 0);
        return res;
    }

    private static void DFS(int[] nums, List<List<Integer>> res, LinkedList<Integer> path,
            boolean[] visited, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1]) && !visited[i - 1]) {
                continue;
            }
            //            if (visited[i]) {
            //                continue;
            //            }
            visited[i] = true;
            path.add(nums[i]);
            DFS(nums, res, path, visited, depth + 1);
            path.removeLast();
            visited[i] = false;
        }
    }

}
