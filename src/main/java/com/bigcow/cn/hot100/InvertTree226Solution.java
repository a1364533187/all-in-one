package com.bigcow.cn.hot100;

public class InvertTree226Solution {

    /**
     * 将二叉树完成翻转
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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
