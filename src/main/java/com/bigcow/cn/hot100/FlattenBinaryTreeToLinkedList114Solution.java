package com.bigcow.cn.hot100;

public class FlattenBinaryTreeToLinkedList114Solution {

    public void flatten(TreeNode root) {
        traversal(root);
    }

    private TreeNode traversal(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = traversal(root.left);
        TreeNode right = traversal(root.right);
        if (left == null) {
            root.right = right;
        } else {
            TreeNode curLeft = left;
            while (curLeft.right != null) {
                curLeft = curLeft.right;
            }
            root.right = left;
            curLeft.right = right;
        }
        root.left = null;
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
