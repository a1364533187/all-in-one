package com.bigcow.cn.code.microsoft;

public class MaximumBinaryTree654Solution {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 6, 0, 5 };
        System.out.println(findMaxIndex(nums, 0, 2));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    private TreeNode traversal(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxIndex = findMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = traversal(nums, start, maxIndex - 1);
        root.right = traversal(nums, maxIndex + 1, end);
        return root;
    }

    private static int findMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
