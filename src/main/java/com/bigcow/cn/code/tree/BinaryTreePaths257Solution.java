package com.bigcow.cn.code.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        backtrace(root, root.val + "", res);
        return res;
    }

    private void backtrace(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        if (root.left != null) {
            backtrace(root.left, path + "->" + root.left.val, res);
        }
        if (root.right != null) {
            backtrace(root.right, path + "->" + root.right.val, res);
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
