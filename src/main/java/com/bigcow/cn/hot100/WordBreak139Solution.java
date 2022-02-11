package com.bigcow.cn.hot100;

import java.util.ArrayList;
import java.util.List;

public class WordBreak139Solution {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (i + 1 < word.length()) {
                    dp[i + 1] = false || dp[i + 1];
                } else {
                    String sWord = s.substring(i + 1 - word.length(), i + 1); // subString 左闭右开
                    dp[i + 1] = (dp[i + 1 - word.length()] && sWord.equals(word)) || dp[i + 1];
                }
                if (dp[i + 1] == true) {
                    continue;
                }
            }
        }
        return dp[s.length()];
    }
}
