package com.bigcow.cn.code.window;

import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinctCharacters159Solution {

    public static void main(String[] args) {
        String s = "abc";
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
            charIndexMap.put(c, end); // 先移动， 不符合要求，shrink window
            while (charIndexMap.size() > 2) { //shrink
                char cc = s.charAt(start);
                int index = charIndexMap.get(cc);
                if (index == start) {
                    charIndexMap.remove(cc);
                }
                start++;
            }
            max = Math.max(end - start + 1, max); // 符合要求后计算
            end++;
        }
        return max;
    }
}
