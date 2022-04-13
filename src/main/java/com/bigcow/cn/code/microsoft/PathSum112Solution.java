package com.bigcow.cn.code.microsoft;

public class PathSum112Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                return true;
            }
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    //方法一
    //    public boolean hasPathSum(TreeNode root, int targetSum) {
    //        if (root == null) {
    //            return false;
    //        }
    //        traverse(root, targetSum - root.val);
    //        return find;
    //    }
    //
    //    boolean find = false;
    //
    //    public void traverse(TreeNode root, int targetSum) {
    //        if (find) {
    //            return;
    //        }
    //        if (root.left == null && root.right == null) {
    //            if (targetSum == 0) {
    //                find = true;
    //            }
    //            return;
    //        }
    //        if (root.left != null) {
    //            traverse(root.left, targetSum - root.left.val);
    //        }
    //        if (root.right != null) {
    //            traverse(root.right, targetSum - root.right.val);
    //        }
    //    }
}
