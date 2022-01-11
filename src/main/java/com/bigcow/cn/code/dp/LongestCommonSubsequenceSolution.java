package com.bigcow.cn.code.dp;

public class LongestCommonSubsequenceSolution {

    // c1 == c2 -> dp[i][j] = dp[i-1][j-1] + 1
    // c1 != c2 -> dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.equals("") || text2.equals("")) {
            return 0;
        }
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                if (c1 == c2) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    int upper = i > 0 ? dp[i - 1][j] : 0;
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    int max = Math.max(upper, left);
                    dp[i][j] = max;
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}
