package com.bigcow.cn.code.bytedance.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (curNode.left != null) {
                    nodeQueue.add(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.add(curNode.right);
                }
                if (i == size - 1) {
                    res.add(curNode.val);
                }
            }
        }
        return res;
    }
}
