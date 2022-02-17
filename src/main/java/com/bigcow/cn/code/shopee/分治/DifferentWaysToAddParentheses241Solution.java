package com.bigcow.cn.code.shopee.分治;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class DifferentWaysToAddParentheses241Solution {

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }

    private static Map<Character, BiFunction<Integer, Integer, Integer>> map = new HashMap<Character, BiFunction<Integer, Integer, Integer>>() {

        {
            put('+', (a, b) -> a + b);
            put('-', (a, b) -> a - b);
            put('*', (a, b) -> a * b);
        }
    };

    // 记忆化
    private static Map<String, List<Integer>> memory = new HashMap<>();

    /**
     * 分治： https://leetcode-cn.com/problems/different-ways-to-add-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-5/
     * @param expression
     * @return
     */
    public static List<Integer> diffWaysToCompute(String expression) {
        if (memory.containsKey(expression)) {
            return memory.get(expression);
        }
        if (expression.isEmpty()) {
            return new ArrayList<>();
        }
        // 递归结束
        int index = 0;
        int num = 0;
        for (index = 0; index < expression.length(); index++) {
            char c = expression.charAt(index);
            if (isOperation(c)) {
                break;
            }
            num = num * 10 + Integer.parseInt("" + c);
        }
        List<Integer> ans = new ArrayList<>();
        if (index == expression.length()) { // 只有数字项了， 借宿
            ans.add(num);
            memory.put(expression, ans);
            return ans;
        }
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isOperation(c)) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i)); // 左闭右开 [2, 5)
                List<Integer> right = diffWaysToCompute(
                        expression.substring(i + 1, expression.length()));
                for (Integer l : left) {
                    for (Integer r : right) {
                        ans.add(map.get(c).apply(l, r));
                    }
                }

            }
        }
        memory.put(expression, ans);
        return ans;
    }

    private static boolean isOperation(char c) {
        if (c == '+' || c == '-' || c == '*') {
            return true;
        }
        return false;
    }
}
