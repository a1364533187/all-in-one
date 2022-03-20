package com.bigcow.cn.code.bytedance.bfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20Solution {

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }

    static Map<Character, Character> map = new HashMap<Character, Character>() {

        {
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }
    };

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != map.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
