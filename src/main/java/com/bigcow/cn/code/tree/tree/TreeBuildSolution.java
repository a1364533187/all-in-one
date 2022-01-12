package com.bigcow.cn.code.tree.tree;

import java.util.HashMap;
import java.util.Map;

public class TreeBuildSolution {

    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root.val);
    }
    //根据中序遍历序列和后序遍历序列重建树， 参考 leetcode:https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72/
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        } ;
        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1,
                valueIndexMap);
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder, int start, int end, int pe,
            Map<Integer, Integer> valueIndexMap) {
        if (start < 0 || end < 0 || start >= inorder.length || end > inorder.length) {
            return null;
        }
        if (start == end) {
            return new TreeNode(inorder[start]);
        }
        if (start > end) {
            return null;
        }
        int rootIndex = valueIndexMap.get(postorder[pe]);
        TreeNode leftNode = buildTree(inorder, postorder, start, rootIndex - 1,
                pe - (end - rootIndex) - 1, valueIndexMap);
        TreeNode rightNode = buildTree(inorder, postorder, rootIndex + 1, end, pe - 1,
                valueIndexMap);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
