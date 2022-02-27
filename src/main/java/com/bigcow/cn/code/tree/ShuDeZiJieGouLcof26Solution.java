package com.bigcow.cn.code.tree;

public class ShuDeZiJieGouLcof26Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B) || isSameTree(A, B);
    }

    public boolean isSameTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val !=  B.val) {
            return false;
        }
        return isSameTree(A.left, B.left) &&  isSameTree(A.right, B.right);
    }
}
