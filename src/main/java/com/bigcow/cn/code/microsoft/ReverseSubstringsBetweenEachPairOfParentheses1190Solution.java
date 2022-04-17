package com.bigcow.cn.code.microsoft;

public class ReverseSubstringsBetweenEachPairOfParentheses1190Solution {

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    public static String reverseParentheses(String s) {
        return reverseParenthesesRecur(new StringBuilder(s), false).toString();
    }

    private static StringBuilder reverseParenthesesRecur(StringBuilder s, boolean reverse) {
        StringBuilder first = new StringBuilder(); //括号前的字符
        int scanIndex = 0;
        // 找到第一个左括号的位置
        for (; scanIndex < s.length(); scanIndex++) {
            char c = s.charAt(scanIndex);
            if (Character.isLowerCase(c)) {
                first.append(c);
            }
            if (c == '(') {
                break;
            }
        }
        if (scanIndex == s.length()) { // 没有左括号，直接结束
            if (reverse) {
                return first.reverse();
            }
            return first;
        }
        // 找到和左括号匹配的右括号
        scanIndex++; // 跳过左括号
        int midLeft = scanIndex;
        int leftBracket = 1;
        for (; scanIndex < s.length(); scanIndex++) {
            Character c = s.charAt(scanIndex);
            if (leftBracket == 1 && c == ')') {
                break;
            }
            if (c == '(') {
                leftBracket++;
            } else if (c == ')') {
                leftBracket--;
            }
        }
        StringBuilder mid = reverseParenthesesRecur(
                new StringBuilder(s.substring(midLeft, scanIndex)), true);
        scanIndex++; // 跳过右括号
        StringBuilder end = reverseParenthesesRecur(new StringBuilder(s.substring(scanIndex)),
                false);
        StringBuilder res = new StringBuilder().append(first).append(mid).append(end);
        if (reverse) {
            return res.reverse();
        }
        return res;
    }
}
