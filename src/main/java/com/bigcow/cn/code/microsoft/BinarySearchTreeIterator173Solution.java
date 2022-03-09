package com.bigcow.cn.code.microsoft;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator173Solution {

    private int idx;
    private List<Integer> arr;

    public BinarySearchTreeIterator173Solution(TreeNode root) {
        arr = new ArrayList<>();
        inOrderTraverse(root, arr);
        idx = 0;
    }

    public int next() {
        return arr.get(idx++);
    }

    public boolean hasNext() {
        return idx < arr.size();
    }

    private void inOrderTraverse(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, arr);
        System.out.println(root.val);
        arr.add(root.val);
        inOrderTraverse(root.right, arr);
    }
}
