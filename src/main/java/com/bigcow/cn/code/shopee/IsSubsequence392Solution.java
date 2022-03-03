package com.bigcow.cn.code.shopee;

public class IsSubsequence392Solution {

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int startS = 0;
        int startT = 0;
        while (startS < s.length() && startT < t.length()) {
            char cs = s.charAt(startS);
            char ts = t.charAt(startT);
            if (cs == ts) {
                startS++;
                startT++;
            } else {
                startT++;
            }
        }
        return startS == s.length();
    }
}
