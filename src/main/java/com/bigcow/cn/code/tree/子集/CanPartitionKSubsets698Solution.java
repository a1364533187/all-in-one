package com.bigcow.cn.code.tree.子集;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CanPartitionKSubsets698Solution {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9 };
        System.out.println(canPartitionKSubsets(nums, 5));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        boolean[] visitied = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        DFS(nums, target, visitied, new LinkedList<>(), res, 0);
        return res.size() == k;
    }

    // 数组反转
    private static void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }

    public static void DFS(int[] nums, int target, boolean[] visited, LinkedList<Integer> path,
            List<List<Integer>> res, int begin) {
        if (target == 0) {
            for (int i = 0; i < path.size(); i++) {
                if (visited[path.get(i)]) {
                    return;
                }
            }
            res.add(new ArrayList<>(path));
            for (int i = 0; i < path.size(); i++) {
                visited[path.get(i)] = true;
            }
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            if (visited[i] || nums[i] > target) {
                continue;
            }
            path.add(i);
            DFS(nums, target - nums[i], visited, path, res, i + 1);
            path.removeLast();
        }
    }
}
