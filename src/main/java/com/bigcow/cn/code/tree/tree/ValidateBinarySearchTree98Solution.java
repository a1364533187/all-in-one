package com.bigcow.cn.code.tree.tree;

public class ValidateBinarySearchTree98Solution {

    public boolean isValidBST(TreeNode root) {
        Long[] res = traversal(root);
        return res[0] == 0;
    }

    // 定义int[] 表示每层节点返回的状态
    // int[0]: 遍历到当前位置是否为二叉搜索树, -1 表示不是二叉搜索树， 0表示是二叉搜索树
    // int[1]: 表示当前节点树的最大值
    // int[2]: 表示当前节点树的最小值

    public Long[] traversal(TreeNode root) {
        if (root == null) {
            return new Long[] { 0L, Long.MIN_VALUE, Long.MAX_VALUE };
        }
        Long[] left = traversal(root.left);
        Long[] right = traversal(root.right);
        Long isValidBST = 0L;
        if (left[0] == -1 || right[0] == -1 || left[1] >= root.val || right[2] <= root.val) {
            isValidBST = -1L;
        }
        Long leftTreeMax = Math.max(Math.max(left[1], root.val), right[1]);
        Long rightTreeMin = Math.min(Math.min(right[2], root.val), left[2]);
        return new Long[] { isValidBST, leftTreeMax, rightTreeMin };
    }
}
