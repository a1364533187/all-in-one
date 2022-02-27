package com.bigcow.cn.code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof34Solution {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        traversal(root, target - root.val, res, path);
        return res;
    }

    public void traversal(TreeNode root, int target, List<List<Integer>> res,
            LinkedList<Integer> path) {
        if (root == null) {
            return;
        }
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            traversal(root.left, target - root.left.val, res, path);
            path.removeLast();
        }
        if (root.right != null) {
            path.add(root.right.val);
            traversal(root.right, target - root.right.val, res, path);
            path.removeLast();
        }
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