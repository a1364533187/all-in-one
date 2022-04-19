package com.bigcow.cn.code.microsoft;

public class CountCompleteTreeNodes222Solution {

    /**
     * 统计完全二叉树的
     * https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-er-ch-iz5t/
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftHeight = 1, rightHeight = 1; // 这里初始为0是有目的的，为了下面求指数方便
        while (left != null) { // 求左子树深度
            left = left.left;
            leftHeight++;
        }
        while (right != null) { // 求右子树深度
            right = right.right;
            rightHeight++;
        }
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1; // 满二叉树的节点个数为 2^leftHeight - 1个
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
