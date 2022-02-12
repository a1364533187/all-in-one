package com.bigcow.cn.hot100;

public class LongestValidParentheses32Solution {

    public static void main(String[] args) {
        //                String s = "(()";
//        String s = "((()))";
//                String s = "((()()()()()))";
//                String s = "()(()";
                String s = ")(((((()())()()))()(()))(";
        System.out.println(longestValidParentheses(s));
    }

    /**
     * 转换为动态规划子问题
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int[] dp = new int[s.length()]; // 截止到当前位置括号对的个数
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else { // ")" s[i-1] = ')'
                    int lBrace = i - dp[i - 1] - 1;
                    if (lBrace >= 0 && s.charAt(lBrace) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (lBrace - 1 >= 0) {
                            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                        }
                    }
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}
