package com.bigcow.cn.hot100;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII437Solution1 {

    /**
     * 树 + 前缀和: https://leetcode-cn.com/problems/path-sum-iii/solution/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        //第一步计算前缀和
        traversalPreSum(root);
        traversal(root);
        int[] count = new int[1];
        Map<Integer, Integer> freqPreSumMap = new HashMap<>();
        freqPreSumMap.put(0, 1);
        calCountTraversal(root, targetSum, count, freqPreSumMap);
        return count[0];
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        traversal(root.left);
        traversal(root.right);
    }

    //计算完前缀和后， 计算节点的差值
    private void calCountTraversal(TreeNode root, int targetSum, int[] count,
                                   Map<Integer, Integer> freqPreSumMap) {
        if (root == null) {
            return;
        }
        System.out.println("freqPreSum: " + freqPreSumMap + " root val:" + root.val);
        int curCount = freqPreSumMap.getOrDefault(root.val - targetSum, 0);
        count[0] += curCount;
        freqPreSumMap.put(root.val, freqPreSumMap.getOrDefault(root.val, 0) + 1);
        System.out.println("freqPreSum: " + freqPreSumMap);
        calCountTraversal(root.left, targetSum, count, freqPreSumMap);
        calCountTraversal(root.right, targetSum, count, freqPreSumMap);
        freqPreSumMap.put(root.val, freqPreSumMap.getOrDefault(root.val, 0) - 1); // Map 需要撤销操作？
    }

    // 第一步，算前缀和, 先序遍历
    public void traversalPreSum(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.val = root.val + root.left.val; // 不需要撤销操作？
            traversalPreSum(root.left);
        }
        if (root.right != null) {
            root.right.val = root.val + root.right.val;
            traversalPreSum(root.right);
        }
    }

}
