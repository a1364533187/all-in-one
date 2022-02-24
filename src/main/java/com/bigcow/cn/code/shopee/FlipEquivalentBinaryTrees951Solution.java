package com.bigcow.cn.code.shopee;

public class FlipEquivalentBinaryTrees951Solution {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        } else if (root2 == null) {
            return false;
        } else {
            if (root1.val != root2.val) {
                return false;
            } else {
                // 翻转
                boolean flip = flipEquiv(root1.left, root2.right)
                        && flipEquiv(root1.right, root2.left);
                // 不翻转
                boolean noFlip = flipEquiv(root1.left, root2.left)
                        && flipEquiv(root1.right, root2.right);
                return flip || noFlip;
            }
        }
    }

}
