package com.bigcow.cn.code.tree.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestor236Solution {

    /**
     * 采用树的后续遍历， 时间复杂度O(N)
     * 空间复杂度：O(N) ，其中 NN 是二叉树的节点数。递归调用的栈深度取决于二叉树的高度，二叉树最坏情况下为一条链，此时高度为 NN，因此空间复杂度为 O(N)O(N)。
     * @param root
     * @param p
     * @param q
     * @return
     */
    //    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //        if (root == null || root == p || root == q) {
    //            return root;
    //        }
    //        TreeNode left = lowestCommonAncestor(root.left, p, q);
    //        TreeNode right = lowestCommonAncestor(root.right, p, q);
    //        if (left != null && right != null) {
    //            return root;
    //        } else if (left != null && right == null) {
    //            return left;
    //        } else if (left == null && right != null) {
    //            return right;
    //        } else {
    //            return null;
    //        }
    //    }

    /**
     * 采用先序遍历，存放根结点到p的路径list1, 存放根结点到q的路径list2 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPtah = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);
        TreeNode resNode = null;
        for (int i = 0; i < pPtah.size() && i < qPath.size(); i++) {
            if (pPtah.get(i) == qPath.get(i)) {
                resNode = pPtah.get(i);
            } else {
                break;
            }
        }
        return resNode;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode node) {
        //        if (root == null) {
        //            return new LinkedList<>();
        //        }
        List<List<TreeNode>> res = new ArrayList<>();
        LinkedList<TreeNode> path = new LinkedList<>();
        path.add(root);
        traversal(root, node, path, res);
        for (int i = 0; i < res.get(0).size(); i++) {
            System.out.print("--->" + res.get(0).get(i).val);
        }
        System.out.println();
        return res.get(0);
    }

    /**
     * node 存在于root的树中， 
     * @param root
     * @param node
     */
    private void traversal(TreeNode root, TreeNode node, LinkedList<TreeNode> path,
            List<List<TreeNode>> res) {
        if (node == root) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            path.add(root.left);
            traversal(root.left, node, path, res);
            path.removeLast();
        }
        if (root.right != null) {
            path.add(root.right);
            traversal(root.right, node, path, res);
            path.removeLast();
        }
    }
}
