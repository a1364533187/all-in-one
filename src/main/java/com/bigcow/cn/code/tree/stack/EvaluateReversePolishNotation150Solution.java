package com.bigcow.cn.code.tree.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluateReversePolishNotation150Solution {

    public static void main(String[] args) {
        //        String[] tokens = {"2","1","+","3","*"};
        String[] tokens = { "4", "13", "5", "/", "+" };
        System.out.println(evalRPN(tokens));
    }

    static Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<String, BiFunction<Integer, Integer, Integer>>() {

        {
            put("+", (a, b) -> a + b);
            put("-", (a, b) -> a - b);
            put("*", (a, b) -> a * b);
            put("/", (a, b) -> a / b);
        }
    };

    public static int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        // 遇到数字入栈
        // 遇到操作符，弹出栈顶2个元素，计算
        // 计算后的接入压入栈中
        for (int i = 0; i < tokens.length; i++) {
            if (map.containsKey(tokens[i])) {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                int cal = map.get(tokens[i]).apply(num1, num2);
                numStack.push(cal);
            } else {
                numStack.push(Integer.valueOf(tokens[i]));
            }
        }
        return numStack.pop();
    }
}
