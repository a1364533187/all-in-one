package com.bigcow.cn.hot100;

import java.util.Stack;

public class FindUnsortedSubarray581Solution {

    public static void main(String[] args) {
        int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
        System.out.println(findUnsortedSubarray(nums));
    }

    //清晰 https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/si-lu-qing-xi-ming-liao-kan-bu-dong-bu-cun-zai-de-/
    public static int findUnsortedSubarray(int[] nums) {
        Stack<Integer> increaseStack = new Stack<>();
        int left = nums.length - 1, right = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (!increaseStack.empty() && nums[increaseStack.peek()] > nums[i]) {
                left = Math.min(left, increaseStack.peek());
                increaseStack.pop();
            }
            increaseStack.push(i);
        }
        Stack<Integer> decreaseStack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            while (!decreaseStack.empty() && nums[decreaseStack.peek()] < nums[i]) {
                right = Math.max(right, decreaseStack.peek());
                decreaseStack.pop();
            }
            decreaseStack.push(i);
        }
        return right - left > 0 ? right - left + 1 : 0;
    }
}
