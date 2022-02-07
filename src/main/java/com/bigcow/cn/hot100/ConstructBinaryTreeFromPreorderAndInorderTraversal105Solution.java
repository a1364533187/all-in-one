package com.bigcow.cn.hot100;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traversal(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode traversal(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
            int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = traversal(preorder, preStart + 1, index - inStart + preStart, inorder, inStart,
                index - 1);
        root.right = traversal(preorder, preEnd + index + 1 - inEnd, preEnd, inorder, index + 1,
                inEnd);
        return root;
    }
}
