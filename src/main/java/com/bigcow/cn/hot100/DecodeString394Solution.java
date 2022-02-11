package com.bigcow.cn.hot100;

import java.util.Stack;

public class DecodeString394Solution {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    public static String decodeString(String s) {
        return decode(s, 0, s.length() - 1);
    }

    // 找到括号里的内容，递归解码
    private static String decode(String s, int start, int end) {
        if (start > end) {
            return "";
        }
        // 找到前面字符串
        String head = "";
        for (int i = start; i <= end; i++) {
            if (s.charAt(start) < '0' || s.charAt(start) > '9') {
                head += s.charAt(start++);
            } else {
                break;
            }
        }
        // 找到数字
        int cnt = 0;
        while (start <= end && s.charAt(start) >= '0' && s.charAt(start) <= '9') {
            cnt = cnt * 10 + s.charAt(start++) - '0';
        }
        ++start; // 跳过左括号
        Stack<Character> lBraceStack = new Stack<>();
        int braceEnd = start;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '[') {
                lBraceStack.add('[');
            }
            if (s.charAt(i) == ']') {
                if (lBraceStack.isEmpty()) {
                    braceEnd = i; // 找到右括号
                    break;
                } else {
                    lBraceStack.pop();
                }
            }
        }
        String t = decode(s, start, braceEnd - 1);
        String tail = decode(s, braceEnd + 1, end);
        String mid = "";
        while (cnt-- > 0) {
            mid += t;
        }
        return head + mid + tail;
    }
}
