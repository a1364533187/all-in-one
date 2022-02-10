package com.bigcow.cn.code.string.palindrome;

public class PalindromicSubstrings647Solution {

    public static void main(String[] args) {
//        String str = "abc";
        String str = "aaa";
        System.out.println(countSubstrings(str));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 单中心扩散
            int countL = countPalindorm(s, i, i);
            // 双中心扩散
            int countR = countPalindorm(s, i, i + 1);
            count += (countL + countR);
        }
        return count;
    }

    /**
     * 单中心、双中心扩散法
     */
    public static int countPalindorm(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}
