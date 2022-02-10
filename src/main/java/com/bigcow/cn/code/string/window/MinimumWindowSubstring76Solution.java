package com.bigcow.cn.code.string.window;

public class MinimumWindowSubstring76Solution {

    /**
     * 滑动窗 + 字母数组
     * https://leetcode-cn.com/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[] win2 = getStrWin256(t);
        int start = 0;
        int end = -1;
        int[] win1 = new int[256];
        String res = null;
        while (end < s.length()) {
            while (isValid(win1, win2)) {
                // 记录结果
                if (res == null || res.length() > end + 1 - start) {
                    res = s.substring(start, end + 1);
                }
                // 缩减win
                // start++
                win1[s.charAt(start)]--;
                start++;
            }
            end++;
            if (end < s.length()) {
                win1[s.charAt(end)]++;
            }
        }

        return res == null ? "" : res;
    }

    private boolean isValid(int[] win1, int[] win2) {
        for (int i = 0; i < win2.length; i++) {
            if (win2[i] > win1[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] getStrWin256(String str) {
        int[] res = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            res[c] += 1;
        }
        return res;
    }
}
