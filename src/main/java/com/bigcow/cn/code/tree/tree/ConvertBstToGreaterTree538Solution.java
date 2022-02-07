package com.bigcow.cn.code.tree.tree;

public class ConvertBstToGreaterTree538Solution {

    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];
        traversal(root, sum);
        return root;
    }

    public TreeNode traversal(TreeNode root, int[] sum) {
        if (root == null) {
            return root;
        }
        traversal(root.right, sum);
        root.val = root.val + sum[0];
        sum[0] = root.val;
        traversal(root.left, sum);
        return root;
    }

    //    int sum = 0;
    //
    //    public TreeNode convertBST(TreeNode root) {
    //        if (root == null) {
    //            return root;
    //        }
    //        convertBST(root.right);
    //        root.val = root.val + sum;
    //        sum = root.val;
    //        convertBST(root.left);
    //        return root;
    //    }

    //    int sum = 0;

    //    public TreeNode convertBST(TreeNode root) {
    //        traversal(root);
    //        return root;
    //    }

    //    // 中序遍历 左中右， 
    //    // 反中序遍历： 右中左 ， 本题的核心
    //    public void traversal(TreeNode root) {
    //        if (root == null) {
    //            return;
    //        }
    //        traversal(root.right);
    //        root.val = sum + root.val;
    //        sum = root.val;
    //        traversal(root.left);
    //    }
}
