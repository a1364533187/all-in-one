package com.bigcow.cn.code.microsoft;

public class BinaryTreeMaximumPathSum124Solution {

    // 记录没有节点的最大路径和， 不一定是根结点，所以可以返回2个值，
    public int maxPathSum(TreeNode root) {
        int[] res = traverse(root);
        return res[1];
    }

    /**
     * 采用后续遍历， 最后遍历的是根
     * int[] 表示的是
     * 数组第一位int[0]表示经过该节点可供其他节点计算的路径和最大值， 1、根结点 2、根结点 + 左节点 3、根结点 + 右节点
     * 数组第二位int[1]表示遍历到该位置最大的路径和， 不一定经过该节点，最后一层层传递到根结点
     *
     *
     * @param root
     * @return
     */
    private int[] traverse(TreeNode root) {
        if (root == null) {
            // 节点值的范围是-1000 <= Node.val <= 1000
            return new int[] { -2000, -2000 }; // 如果是最小的负数，有可能溢出
        }
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        int cur = Math.max(Math.max(root.val, root.val + left[0]), root.val + right[0]);

        return new int[] { cur, Math.max(Math.max(Math.max(cur, left[1]), right[1]),
                root.val + left[0] + right[0]) };
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
