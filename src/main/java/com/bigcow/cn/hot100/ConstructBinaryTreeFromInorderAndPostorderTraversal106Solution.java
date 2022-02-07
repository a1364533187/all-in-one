package com.bigcow.cn.hot100;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal106Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return traversal(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode traversal(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
            int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = traversal(inorder, inStart, index - 1, postorder, postStart,
                postStart + index - 1 - inStart);
        root.right = traversal(inorder, index + 1, inEnd, postorder, postEnd + index - inEnd,
                postEnd - 1);
        return root;
    }
}
