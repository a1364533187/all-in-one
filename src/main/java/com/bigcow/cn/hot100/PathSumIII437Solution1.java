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
        System.out.println(root.val); // 这里不会影响到左右子树的结果
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
//        freqPreSumMap.put(root.val, freqPreSumMap.getOrDefault(root.val, 0) - 1); // Map 需要撤销操作
//        freqPreSumMap.put(root.val, freqPreSumMap.getOrDefault(root.val, 0) + 1);
        // 这里一减一加，相互取消了
        calCountTraversal(root.right, targetSum, count, freqPreSumMap);
        freqPreSumMap.put(root.val, freqPreSumMap.getOrDefault(root.val, 0) - 1); // Map 需要撤销操作？
        // 状态恢复代码的作用就是： 在遍历完一个节点的所有子节点后，将其从map中除去。否则左子树的结果会影响到右子树的结果
        // 见leetcode: https://leetcode-cn.com/problems/path-sum-iii/solution/dui-qian-zhui-he-jie-fa-de-yi-dian-jie-s-dey6/
    }

    // 第一步，算前缀和, 先序遍历
    public void traversalPreSum(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.val = root.val + root.left.val; // 不需要撤销操作， 原因是这里左子树的结果， 并不会影响到右子树
            traversalPreSum(root.left);
//            root.left.val =  root.left.val - root.val;  原因是root 和 root.left 是不相关的2层

            /*
            2、是否要回溯：二叉树的问题大部分是不需要回溯的，原因如下：
            二叉树的递归部分：dfs(root->left),dfs(root->right)已经把可能的路径穷尽了,
                    因此到任意叶节点的路径只可能有一条，绝对不可能出现另外的路径也到这个满足条件的叶节点的;

            而对比二维数组(例如迷宫问题)的DFS,for循环向四个方向查找每次只能朝向一个方向，并没有穷尽路径，
            因此某一个满足条件的点可能是有多条路径到该点的

            并且visited数组标记已经走过的路径是会受到另外路径是否访问的影响，这时候必须回溯

            作者：eh-xing-qing
            链接：https://leetcode-cn.com/problems/path-sum-iii/solution/yi-pian-wen-zhang-jie-jue-suo-you-er-cha-smch/
            来源：力扣（LeetCode）
            著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
             */
        }
        if (root.right != null) {
            root.right.val = root.val + root.right.val;
            traversalPreSum(root.right);
        }
    }

}
