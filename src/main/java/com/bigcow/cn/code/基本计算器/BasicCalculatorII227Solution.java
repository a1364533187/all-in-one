package com.bigcow.cn.code.基本计算器;

import java.util.Stack;

public class BasicCalculatorII227Solution {

    /**
     * 计算器非常简洁的代码, 学习可以参考labuladong的代码：拆解复杂问题实现计算器： https://segmentfault.com/a/1190000038560794
     * https://convivae.top/posts/ji-ben-ji-suan-qi-ii/
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
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
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
}
