package com.bigcow.cn.code.shopee;

public class LongestRepeatingCharacterReplacement424Solution {

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        int[] win = new int[26];
        int res = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            win[c - 'A']++;
            while (needShrinkWindow(win, k)) {
                char cStart = s.charAt(start);
                win[cStart - 'A']--;
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }

    private static boolean needShrinkWindow(int[] window, int k) {
        int top = 0;
        int sum = 0;
        for (int i = 0; i < window.length; i++) {
            sum += window[i];
            if (window[i] > top) {
                top = window[i];
            }
        }
        return sum - top > k;
    }
}
