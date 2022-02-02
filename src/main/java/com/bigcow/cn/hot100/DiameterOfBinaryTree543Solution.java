package com.bigcow.cn.hot100;

public class DiameterOfBinaryTree543Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return len(root.left) + len(root.right);
    }

    // 计算数的深度
    public int len(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = len(root.left) + 1;
        int right = len(root.right) + 1;
        return Math.max(left, right);
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
