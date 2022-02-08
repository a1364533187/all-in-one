package com.bigcow.cn.code.tree.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII113Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        traversal(root, targetSum - root.val, path, res);
        return res;
    }

    private void traversal(TreeNode root, int targetSum, LinkedList<Integer> path,
            List<List<Integer>> res) {
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            traversal(root.left, targetSum - root.left.val, path, res);
            path.removeLast();
        }

        if (root.right != null) {
            path.add(root.right.val);
            traversal(root.right, targetSum - root.right.val, path, res);
            path.removeLast(); // path 是左右子树公用的， 需要  add 以及撤销
        }

    }
}
