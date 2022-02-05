package com.bigcow.cn.hot100;

public class MaxPathSum124Solution {

    public int maxPathSum(TreeNode root) {
        int val = dfs(root);
        System.out.println(val);
        return res;
    }

    int res = Integer.MIN_VALUE;

    // 计算 max(根结点在内的左子树最长的路径,根结点在内的右子树最长的路径)
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        res = Math.max(res, root.val + left + right);
        return Math.max(left + root.val, right + root.val);
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
