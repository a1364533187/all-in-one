package com.bigcow.cn.code.window;

import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinctCharacters159Solution {

    public static void main(String[] args) {
        String s = "ccbbbaaa";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    /**
     * 滑动窗 + Hashamp
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            charIndexMap.put(c, end);
            while (charIndexMap.size() > 2) { //shrink
                char cc = s.charAt(start);
                int index = charIndexMap.get(cc);
                if (index == start) {
                    charIndexMap.remove(cc);
                }
                start++;
            }
            max = Math.max(end - start + 1, max);
            end++;
        }
        return Math.max(end - start, max);
    }
}
