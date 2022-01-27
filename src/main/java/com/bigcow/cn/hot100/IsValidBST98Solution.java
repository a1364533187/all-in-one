package com.bigcow.cn.hot100;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST98Solution {

    public boolean isValidBST(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        inorderTravel(root, path);
        //检查path 是否有序
        for (int i = 1; i < path.size(); i++) {
            if (path.get(i) <= path.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorderTravel(TreeNode root, List<Integer> path) {
        if (null != root) {
            inorderTravel(root.left, path);
            path.add(root.val);
            inorderTravel(root.right, path);
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
}
