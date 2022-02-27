package com.bigcow.cn.code.tree;

public class MaximumDifferenceBetweenNodeAndAncestor1026Solution {

    public int maxAncestorDiff(TreeNode root) {
        int[] res = diff(root);
        return res[2];
    }

    /**
     * 
     */
    private int[] diff(TreeNode root) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }
        if (root.left == null && root.right == null) {
            return new int[] { root.val, root.val, 0 };
        }
        int[] left = diff(root.left);
        int[] right = diff(root.right);

        int min = Math.min(root.val, Math.min(left[0], right[0]));
        int max = Math.max(root.val, Math.max(left[1], right[1]));
        int diffMax = Math.max(left[2], right[2]);
        int diffVal = Math.max(diffMax, Math.max(max - root.val, root.val - min));
        return new int[] { min, max, diffVal };
    }
}
