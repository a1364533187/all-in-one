package com.bigcow.cn.code.microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII113Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        traverse(res, path, root, targetSum - root.val);
        return res;
    }

    public void traverse(List<List<Integer>> res, LinkedList<Integer> path, TreeNode root,
            int targetSum) {
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            traverse(res, path, root.left, targetSum - root.left.val);
            path.removeLast();
        }

        if (root.right != null) {
            path.add(root.right.val);
            traverse(res, path, root.right, targetSum - root.right.val);
            path.removeLast();
        }
    }
}
