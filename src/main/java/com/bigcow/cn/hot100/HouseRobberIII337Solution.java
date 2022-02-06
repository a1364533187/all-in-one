package com.bigcow.cn.hot100;

public class HouseRobberIII337Solution {

    public int rob(TreeNode root) {
        int[] dp = robTraversal(root);
        return Math.max(dp[0], dp[1]);
    }

    /**
     * int[] 0 号位置表示不选择root节点打劫的最大值， 1号元素表示选择root节点时打劫的最大值
     * 利用后序遍历，避免重复计算， 返回值int[]是大亮点， 值得N刷
     * @param root
     * @return
     */
    private int[] robTraversal(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] left = robTraversal(root.left);
        int[] right = robTraversal(root.right);
        int[] cal = new int[2];
        cal[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        cal[1] = root.val + left[0] + right[0];
        return new int[] { cal[0], cal[1] };
    }
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
