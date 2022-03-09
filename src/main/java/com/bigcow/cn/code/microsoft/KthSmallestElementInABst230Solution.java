package com.bigcow.cn.code.microsoft;

public class KthSmallestElementInABst230Solution {

    public int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return val;
    }

    int count = 0;
    int val = -1;

    private void traversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (val == -1) {
            traversal(root.left, k);
            count++;
            if (count == k) {
                val = root.val;
            }
            traversal(root.right, k);
        }

    }
}
