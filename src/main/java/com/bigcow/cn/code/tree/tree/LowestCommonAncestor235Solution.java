package com.bigcow.cn.code.tree.tree;

public class LowestCommonAncestor235Solution {

    /**
     * 二叉搜索树找最低公共祖先, 只遍历一条边
     * @param root
     * @param p
     * @param q
     * @return
     */
    //    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //        if (root == null || root.val >= p.val && root.val <= q.val
    //                || root.val <= p.val && root.val >= q.val) {
    //            return root;
    //        } else if (root.val > p.val && root.val > q.val) { // 搜索左子树
    //            return lowestCommonAncestor(root.left, p, q);
    //        } else {
    //            return lowestCommonAncestor(root.right, p, q);
    //        }
    //    }

    // 遍历整个树写法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}
