package com.bigcow.cn.code.tree.tree;

public class DiameterOfBinaryTree543Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = traversal(root);
        return res[0];
    }

    /**
     * int[] int[0] 存放的是截止到当前节点的最大路径(不一定包含当前节点)
     * int[1] 存放的是当前节点到左子树或者右子树最大的路径
     * @param root
     * @return
     */
    public int[] traversal(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] left = new int[] { 0, 0 };
        if (root.left != null) {
            left = traversal(root.left);
            left[1] += 1;
        }
        int[] right = new int[] { 0, 0 };
        if (root.right != null) {
            right = traversal(root.right);
            right[1] += 1;
        }
        int max = Math.max(Math.max(left[0], left[1] + right[1]), right[0]);
        return new int[] { max, Math.max(left[1], right[1]) };
    }
}
