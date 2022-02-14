package com.bigcow.cn.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses301Solution {

    public static List<String> removeInvalidParentheses(String s) {
        // 先统计需要删除的左括号数和右括号数
        int[] needRemoveBrace = needToRemoveLeftAndRightBrace(s);
        // 如果字符串本身就是合法的，就不用删除了
        if (needRemoveBrace[0] == 0 && needRemoveBrace[1] == 0) {
            return Arrays.asList(s);
        }
        Set<String> ans = new HashSet<>();
        dfs(ans, s, 0, "", needRemoveBrace[0], needRemoveBrace[1]);
        return new ArrayList<>(ans);
    }

    private static void dfs(Set<String> ans, String s, int index, String sb, int rmLeftBrace,
                            int rmRightBrace) {
        if (index == s.length()) {
            if (rmLeftBrace == 0 && rmLeftBrace == 0 && isValid(sb)) {
                ans.add(sb);
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            // 移除当前的左括号，或者不移除
            //移除当前的左括号
            dfs(ans, s, index + 1, sb, rmLeftBrace - 1, rmRightBrace);
            //不移除当前的左括号
            dfs(ans, s, index + 1, sb + "(", rmLeftBrace, rmRightBrace);
        } else if (c == ')') {
            // 移除右括号，或者不移除
            //移除当前的右括号
            dfs(ans, s, index + 1, sb, rmLeftBrace, rmRightBrace - 1);
            //不移除当前的右括号
            dfs(ans, s, index + 1, sb + ")", rmLeftBrace, rmRightBrace);
        } else {
            // 不做改动， 比如是字符串a
            dfs(ans, s, index + 1, sb + c, rmLeftBrace, rmRightBrace);
        }
    }

    public static void main(String[] args) {
        //        String s = "((())))";
        //        String s = "()())(()";
        //        int[] res = needToRemoveLeftAndRightBrace(s);
        //        System.out.println(res[0] + "---" + res[1]);

        String s = "()())()";
        System.out.println(removeInvalidParentheses(s));
    }

    /**
     * 统计待移除的左括号个数和右括号个数
     */
    private static int[] needToRemoveLeftAndRightBrace(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        return new int[] { left, right };
    }

    private static boolean isValid(String sb) {
        // 判断括号是否合法
        int left = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    return false;
                } else {
                    left--;
                }
            }
        }
        return left == 0;
    }
}
