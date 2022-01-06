package com.bigcow.cn.code.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TreeUtils {

    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 5, 3, null, 9 };
        TreeNode root = buildTree(nums);
        System.out.println(largestValues(root));
    }

    public static List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> maxArrs = new ArrayList<>();
        //定义2个Queue， 一个记录node, 一个记录node的层级, 先进先出
        Queue<TreeNode> nodeStack = new LinkedList<>();
        Queue<Integer> levelStack = new LinkedList<>();
        nodeStack.add(root);
        levelStack.add(1);
        int prevLevel = 1;
        int max = root.val;
        while (!nodeStack.isEmpty()) {
            TreeNode curNode = nodeStack.poll();
            Integer curLevel = levelStack.poll();
            if (curLevel > prevLevel) {
                prevLevel = curLevel;
                maxArrs.add(max);
                max = curNode.val;
            } else {
                max = Math.max(curNode.val, max);
            }
            if (curNode.left != null) {
                nodeStack.add(curNode.left);
                levelStack.add(curLevel + 1);
            }
            if (curNode.right != null) {
                nodeStack.add(curNode.right);
                levelStack.add(curLevel + 1);
            }
        }
        maxArrs.add(max);
        return maxArrs;
    }

    public static void buildTreeTest() {
        Integer[] nums = { 1, 3, 2, 5, 3, null, 9 };
        TreeNode root = buildTree(nums);
        travels(root);
    }

    public static void travels(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        travels(root.left);
        travels(root.right);
    }

    public static TreeNode buildTree(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        Map<Integer, TreeNode> indexMem = new HashMap<>();
        indexMem.put(0, root);
        for (int i = 0; i < nums.length; i++) {
            TreeNode curNode = indexMem.get(i);
            if (null == curNode) {
                continue;
            }
            if (2 * i + 1 < nums.length && nums[2 * i + 1] != null) {
                if (null == curNode.left) {
                    curNode.left = new TreeNode(nums[2 * i + 1]);
                    indexMem.put(2 * i + 1, curNode.left);
                }
            }
            if (2 * i + 2 < nums.length && nums[2 * i + 2] != null) {
                if (null == curNode.right) {
                    curNode.right = new TreeNode(nums[2 * i + 2]);
                    indexMem.put(2 * i + 2, curNode.right);
                }
            }
        }
        return root;
    }

    static class TreeNode {

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
