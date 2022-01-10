package com.bigcow.cn.code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermuteSolution_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }

    // 回溯 + 剪枝
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        DFS(res, list, nums, 0);
        return res;
    }

    private static void DFS(List<List<Integer>> res, LinkedList<Integer> path, int[] nums, int depth) {
        //当到达决策树最底层的时候终止
        if (depth == nums.length ) {
            // 变量 path 所指向的列表 在深度优先遍历的过程中只有一份 ，深度优先遍历完成以后，回到了根结点，成为空列表。
            // res.add(path); -> [[], [], [], [], [], []], 引用传递， 回到根结点，都为[]了
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            //选做择添加到路径中
            path.add(nums[i]);
            //继续向下探索
            DFS(res, path, nums, depth + 1);
            //撤销选择
            path.removeLast();
        }
    }
}
