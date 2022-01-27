package com.bigcow.cn.hot100;

import java.util.LinkedList;
import java.util.List;

public class InorderTraversal94Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> path = new LinkedList<>();
        DFS(root, path);
        return path;
    }

    private void DFS(TreeNode root, LinkedList<Integer> path) {
        if (null != root) {
            DFS(root.left, path);
            path.add(root.val);
            DFS(root.right, path);
        }
    }

    public class TreeNode {

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
