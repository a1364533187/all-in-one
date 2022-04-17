package com.bigcow.cn.code.microsoft;

public class ReverseSubstringsBetweenEachPairOfParentheses1190Solution {

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    public static String reverseParentheses(String s) {
        return reverseParenthesesRecur(s, false);
    }

    private static String reverseParenthesesRecur(String s, boolean reverse) {
        String first = ""; //括号前的字符
        int scanIndex = 0;
        // 找到第一个左括号的位置
        for (; scanIndex < s.length(); scanIndex++) {
            char c = s.charAt(scanIndex);
            if (Character.isLowerCase(c)) {
                first += c;
            }
            if (c == '(') {
                break;
            }
        }
        if (scanIndex == s.length()) { // 没有左括号，直接结束
            if (reverse) {
                return reverse(first);
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
        String mid = reverseParenthesesRecur(s.substring(midLeft, scanIndex), true);
        scanIndex++; // 跳过右括号
        String end = reverseParenthesesRecur(s.substring(scanIndex), false);
        String res = first + mid + end;
        if (reverse) {
            return reverse(res);
        }
        return res;
    }

    private static String reverse(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            res += chars[i];
        }
        return res;
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
