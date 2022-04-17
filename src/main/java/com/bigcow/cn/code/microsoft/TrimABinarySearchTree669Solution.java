package com.bigcow.cn.code.microsoft;

public class TrimABinarySearchTree669Solution {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) { // 根结点 有问题 ，将根节点和左子树全部干掉
            return trimBST(root.right, low, high);
        }
        if (root.val > high) { // 根结点 有问题， 将根结点和右子树全部干掉
            return trimBST(root.left, low, high);
        }
        // 根结点 没有有问题， 修剪左右子树
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
