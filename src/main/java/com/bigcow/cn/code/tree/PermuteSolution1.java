package com.bigcow.cn.code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermuteSolution1 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        DFS(res, list, nums);
        return res;
    }

    private static void DFS(List<List<Integer>> res, LinkedList<Integer> path, int[] nums) {
        //当到达决策树最底层的时候终止
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) { // for 循环 宽度
            //选做择添加到路径中
            path.add(nums[i]);
            //继续向下探索
            DFS(res, path, nums); // 递归 深度
            //撤销选择
            path.removeLast();
        }
    }
}
