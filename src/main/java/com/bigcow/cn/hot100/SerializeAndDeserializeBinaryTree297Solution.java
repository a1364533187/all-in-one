package com.bigcow.cn.hot100;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SerializeAndDeserializeBinaryTree297Solution {

    // Encodes a tree to a single string.
    // 就打印前序遍历 + 中序遍历的结果，以@分割, 数字之间以#号分割
    public String serialize(TreeNode root) {
        String prePath = "";
        traversalPreOrder(root, prePath);
        prePath = prePath.substring(1);
        String inPath = "";
        traversalInOrder(root, inPath);
        inPath = inPath.substring(1);
        return prePath + "@" + inPath;
    }

    private void traversalPreOrder(TreeNode root, String prePath) {
        if (root == null) {
            return;
        }
        prePath += "#" + root.val;
        traversalPreOrder(root.left, prePath);
        traversalPreOrder(root.right, prePath);
    }

    private void traversalInOrder(TreeNode root, String inPath) {
        if (root == null) {
            return;
        }
        traversalPreOrder(root.left, inPath);
        inPath += "#" + root.val;
        traversalPreOrder(root.right, inPath);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}
