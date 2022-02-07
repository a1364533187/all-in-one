package com.bigcow.cn.code.tree.tree;

public class BalancedBinaryTree110Solution {

    public boolean isBalanced(TreeNode root) {
        int[] res = traversal(root);
        return res[0] == 0;
    }

    // 在遍历二叉树的过程，既需要知道树的高度用于对比，又需要知道当前节点是否是二叉树，索性返回值为2个
    // int[] int[0] 表示是否为平衡二叉树， 其中-1为非平衡二叉树，0 为平衡二叉树
    // int[] int[1] 表示二叉树的深度
    // 采用后序遍历，需要提前知道左子树和右子树的情况
    public int[] traversal(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] left = traversal(root.left);
        int[] right = traversal(root.right);
        int depth = Math.max(left[1] + 1, right[1] + 1);
        int isBalancedCur = 0;
        if (left[0] == -1 || right[0] == -1 || Math.abs(left[1] - right[1]) > 1) {
            isBalancedCur = -1;
        }
        return new int[] { isBalancedCur, depth };
    }
}
