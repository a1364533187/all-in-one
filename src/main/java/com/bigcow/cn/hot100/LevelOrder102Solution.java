package com.bigcow.cn.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder102Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        nodeQueue.add(root);
        levelQueue.add(1);
        List<Integer> path = new ArrayList<>();
        res.add(path);
        int curLevel = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int level = levelQueue.poll();

            if (level == curLevel) {
                List<Integer> lastList = res.get(res.size() - 1);
                lastList.add(node.val);
            } else {
                List<Integer> newPath = new ArrayList<>();
                newPath.add(node.val);
                res.add(newPath);
                curLevel = level;
            }
            if (null != node.left) {
                nodeQueue.add(node.left);
                levelQueue.add(curLevel + 1);
            }
            if (null != node.right) {
                nodeQueue.add(node.right);
                levelQueue.add(curLevel + 1);
            }
        }
        return res;
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
}
