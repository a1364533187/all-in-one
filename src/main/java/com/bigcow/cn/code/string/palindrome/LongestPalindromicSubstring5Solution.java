package com.bigcow.cn.code.string.palindrome;

public class LongestPalindromicSubstring5Solution {

    /**
     * 单中心 以及双中心扩散法
     * https://www.cnblogs.com/labuladong/p/13945726.html
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res = "" + s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            //以i为中心扩散
            String oneCenter = getPalindrome(s, i, i);
            //以i, i+1 双中心扩散
            String twoCenter = getPalindrome(s, i, i + 1);
            res = findLargestString(res, oneCenter, twoCenter);
        }
        return res;
    }

    private String findLargestString(String str1, String str2, String str3) {
        String temp = "";
        if (str1.length() > str2.length()) {
            temp = str1;
        } else {
            temp = str2;
        }

        if (temp.length() < str3.length()) {
            temp = str3;
        }
        return temp;
    }

    // 从中心往两头扩散, 可以是单中心，也可以是双中心
    public String getPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r); // subString 左闭右开 [)
    }

}
