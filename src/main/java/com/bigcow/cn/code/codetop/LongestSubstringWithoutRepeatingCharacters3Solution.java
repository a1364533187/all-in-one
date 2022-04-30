package com.bigcow.cn.code.codetop;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3Solution {

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int res = 1;
        charIndexMap.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            dp[i] = Math.min(dp[i - 1] + 1, i - charIndexMap.getOrDefault(s.charAt(i), -1));
            res = Math.max(dp[i], res);
            charIndexMap.put(s.charAt(i), i);
        }
        return res;
    }
}
