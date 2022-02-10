package com.bigcow.cn.code.string.window;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString438Solution {

    public static void main(String[] args) {
//        String str1 = "acbdefgbac";
//        String str2 = "abc";

        String str1 = "aaaaaaaaaa";
        String str2 = "aaaaaaaaaaaaa";
        System.out.println(findAnagrams(str1, str2));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        int[] win2 = getStrWin(p);
        // 先记录上到K的位置
        int[] win1 = getStrWin(s.substring(0, p.length()));
        int start = 0;
        int end = p.length() - 1;
        List<Integer> res = new ArrayList<>();
        while (end < s.length()) {
            if (isSame(win1, win2)) {
                res.add(start);
            }
            win1[s.charAt(start) - 'a'] -= 1;
            start++;
            end++;
            if (end < s.length()) {
                win1[s.charAt(end) - 'a'] += 1;
            }
        }
        return res;
    }

    public static int[] getStrWin(String str) {
        int[] res = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            res[c - 'a'] += 1;
        }
        return res;
    }

    //
    private static boolean isSame(int[] nums1, int[] nums2) {
        for (int i = 0; i < 26; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }
}
