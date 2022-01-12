package com.bigcow.cn.code.tree.tree;

import com.bigcow.cn.code.tree.tree.TreeNode;

public class IsBalancedTreeSolution {

    // https://leetcode-cn.com/problems/balanced-binary-tree/solution/jian-ji-di-gui-bi-xu-miao-dong-si-lu-jia-0q19/
    public boolean isBalanced(TreeNode root) {
        getTreeDepth(root);
        return isBalanced;
    }

    boolean isBalanced = true;

    // 妙啊，在后续遍历计算数的深度时， 判断是否是平衡树
    public int getTreeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(node.left);
        int rightDepth = getTreeDepth(node.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
