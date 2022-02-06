package com.bigcow.cn.code.tree.tree;

public class ConvertBstToGreaterTree538Solution {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    // 中序遍历 左中右， 
    // 反中序遍历： 右中左 ， 本题的核心
    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.right);
        root.val = sum + root.val;
        sum = root.val;
        traversal(root.left);
    }
}
