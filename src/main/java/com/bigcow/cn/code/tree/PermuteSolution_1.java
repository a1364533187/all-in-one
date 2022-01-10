package com.bigcow.cn.code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermuteSolution_1 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }

    // 回溯 + 剪枝
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        //用来记录节点是否被访问
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        DFS(res, list, nums, visited);
        return res;
    }

    private static void DFS(List<List<Integer>> res, LinkedList<Integer> path, int[] nums, boolean[] visited) {
        //当到达决策树最底层的时候终止
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //如果已经访问过，则跳过
            if (visited[i]) {
                continue;
            }
            //标识当前位置元素已访问
            visited[i] = true;
            //选做择添加到路径中
            path.add(nums[i]);
            //继续向下探索
            DFS(res, path, nums, visited);
            //撤销选择
            path.removeLast();
            //撤销标记
            visited[i] = false;
        }
    }
}
