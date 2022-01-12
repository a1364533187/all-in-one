package com.bigcow.cn.code.tree.tree;

public class LowestCommonAncestorSolution {

    //妙啊，https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);

        if (leftAncestor != null && rightAncestor != null) {
            return root;
        } else if (rightAncestor != null) {
            return rightAncestor;
        } else {
            return leftAncestor;
        }
    }
}
