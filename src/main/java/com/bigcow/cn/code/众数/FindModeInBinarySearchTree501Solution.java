package com.bigcow.cn.code.众数;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FindModeInBinarySearchTree501Solution {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        inorderTraverse(root, map);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Integer key : map.keySet()) {
            priorityQueue.add(new int[] { key, map.get(key) });
        }
        List<Integer> res = new ArrayList<>();
        int[] arr1 = priorityQueue.poll();
        res.add(arr1[0]);
        while (!priorityQueue.isEmpty() && arr1[1] == priorityQueue.peek()[1]) {
            res.add(priorityQueue.poll()[0]);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void inorderTraverse(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        inorderTraverse(root.right, map);
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
