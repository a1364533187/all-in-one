package com.bigcow.cn.hot100;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring3Solution {

    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    //采用动态规划求解， 值得二刷
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char cPre = s.charAt(i - 1);
            int v = map.getOrDefault(c, -1);
            if (c == cPre) {
                dp[i] = 1;
            } else {
                dp[i] = Math.min(i - v, dp[i - 1] + 1);
            }
            map.put(c, i);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
