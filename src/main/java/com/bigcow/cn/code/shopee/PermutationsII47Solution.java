package com.bigcow.cn.code.shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII47Solution {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, res, new LinkedList<>(), visited);
        return res;
    }

    public static void dfs(int[] nums, List<List<Integer>> res, LinkedList<Integer> path,
            boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i> 0 && nums[i] == nums[i-1] && !visited[i-1])) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, res, path, visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}
