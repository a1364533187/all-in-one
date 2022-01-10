package com.bigcow.cn.code.tree.组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDupSolution {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        DFS(nums, 0, res, new LinkedList<>(), visited);
        return res;
    }

    private static void DFS(int[] nums, int start, List<List<Integer>> res,
            LinkedList<Integer> path, boolean[] visited) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) { // 横向操作的节点
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            DFS(nums, i + 1, res, path, visited); // i + 1 指的是纵向可选的节点
            path.removeLast();
            visited[i] = false;
        }
    }
}
