package com.bigcow.cn.code.bytedance.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree111Solution {

    /**
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int depth = 0;
        while (!nodeQueue.isEmpty()) {
            depth++;
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (curNode.left == null && curNode.right == null) {
                    return depth;
                }
                if (curNode.left != null) {
                    nodeQueue.add(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.add(curNode.right);
                }
            }
        }
        return depth;
    }
}
