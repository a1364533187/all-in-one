package com.bigcow.cn.code.shopee;

public class BinaryTreePruning814Solution {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        // 这里依赖的是后续遍历返回的结果， 所以是left 和 right 而不是root.left 和 root.right
        if (root.val == 0 && left == null && right == null) {
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
