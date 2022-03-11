package com.bigcow.cn.code.基本计算器;

import java.util.Stack;

public class BasicCalculatorXSolution {

    /**
     * labuladong 拆解复杂问题实现计算器： https://segmentfault.com/a/1190000038560794
     * https://leetcode-cn.com/problems/basic-calculator/solution/li-yong-zhan-de-si-lu-by-marcqaq-swog/
     * @param s
     * @return
     */
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char preSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') { // 找到匹配的右括号，将括号内的结果计算出来
                int rightBacketIndex = getMatchRightBacket(s, i);
                String backetStr = s.substring(i + 1, rightBacketIndex); //左闭右开
                num = calculate(backetStr);
                i = rightBacketIndex;
            }
            if (!Character.isDigit(c) && c != ' ' && c != '(' || i == s.length() - 1 || c == ')') {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                num = 0;
                preSign = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private static int getMatchRightBacket(String s, int leftBacketIndex) {
        int left = 1;
        for (int i = leftBacketIndex + 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                left--;
            }
            if (left == 0) {
                return i;
            }
        }
        return -1;
    }
}
