package com.bigcow.cn.code.dp;

public class MinDistance72Solution {

    public static void main(String[] args) {
        System.out.println(minDistance("", "a"));
    }

    /**
     * dp[i][j] 表示word1 第i个位置到word2 第j个位置的编辑距离
     *
     * 当word1[i] == word[j]
     * dp[i][j] == dp[i-1][j-1]
     *
     * 当word1[i] != word[j]
     * 1、增加字符 在dp[i-1][j-1] + 1
     * 2、替换 dp[i-1][j] + 1
     * 3、替换 dp[i][j-1] + 1
     * min(dp[i-1][j-1] + 1, dp[i-1][j] + 1, dp[i][j-1] + 1)
     * 
     * https://leetcode-cn.com/problems/edit-distance/solution/edit-distance-by-ikaruga/
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + 1);
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
