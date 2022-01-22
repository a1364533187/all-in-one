package com.bigcow.cn.code.dp;

import java.util.List;

import com.google.common.collect.Lists;

public class WordBreakSolution {

    public static void main(String[] args) {
        //s = "leetcode", wordDict = ["leet", "code"]
        // "catsandog", ["cats","dog","sand","and","cat"]
        System.out.println(wordBreak("catsandog", Lists.newArrayList("cats","dog","sand","and","cat")));
    }

    /**
     * 和完全平方数分割很像
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                int beginIndex = i - word.length();
                if (beginIndex >= -1) {
                    String subWord = s.substring(beginIndex + 1, i + 1);
                    if (beginIndex == -1) {
                        dp[i] = subWord.equals(word);
                    } else {
                        dp[i] = dp[beginIndex] && subWord.equals(word);
                    }
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
