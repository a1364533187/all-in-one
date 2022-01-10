package com.bigcow.cn.code.tree.排列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permution {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        //[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        DFS(nums, res, new LinkedList<>(), visited);
        return res;
    }

    private static void DFS(int[] nums, List<List<Integer>> res, LinkedList<Integer> path,
            boolean[] visited) {
        if (path.size() == nums.length) { // 到达叶子节点， 也可以看看非叶子节点
            res.add(new ArrayList<>(path));
            return;
        }
        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            DFS(nums, res, path, visited);
            visited[i] = false;
            path.removeLast();
        }
    }
}
