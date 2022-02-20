package com.bigcow.cn.code.shopee;

import java.util.Stack;

public class ValidParenthesisString678Solution {

    public static void main(String[] args) {
        String s = "(*)()";
        System.out.println(checkValidString(s));
    }

    /**
     * https://leetcode-cn.com/problems/valid-parenthesis-string/solution/wei-rao-li-lun-ken-ding-shi-zhan-ya-by-w-op09/
     * @param s
     * @return
     */
    public static boolean checkValidString(String s) {
        Stack<Integer> leftBraceStack = new Stack<>(); // 存左括号的索引
        Stack<Integer> starStack = new Stack<>(); // 存*的索引
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftBraceStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {
                if (!leftBraceStack.isEmpty()) {
                    leftBraceStack.pop();
                    continue;
                }
                if (!starStack.isEmpty()) {
                    starStack.pop();
                    continue;
                }

                if (leftBraceStack.isEmpty() && starStack.isEmpty()) {
                    return false;
                }
            }
        }
        while (!leftBraceStack.isEmpty()) {
            int leftInd = leftBraceStack.pop();
            if (starStack.isEmpty()) {
                return false;
            } else {
                int starInd = starStack.pop();
                if (starInd < leftInd) {
                    return false;
                }
            }
        }
        return true;
    }
}
