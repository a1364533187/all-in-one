package com.bigcow.cn.code.shopee;

public class longestSubstringWithAtLeastKRepeatingCharacters395Solution {

    public static void main(String[] args) {
        String s = "weitong";
        System.out.println(longestSubstring(s, 2));
    }

    // 递归分治
    // https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/fen-zhi-jian-dan-jian-zhi-qing-song-100-ym8se/

    private static int max = 0;

    public static int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        int[] wordCount = calWordCount(s);
        int index = findLessThanKIndex(wordCount, k);
        if (index == -1 || index == 26) { // 找不到小于K的位置
            max = Math.max(max, s.length());
            return s.length();
        }
        char split = (char) (index + 'a');
        String[] splits = s.split(String.valueOf(split));
        for (int i = 0; i < splits.length; i++) {
            int res = longestSubstring(splits[i], k);
            max = Math.max(res, max);
        }
        return max;
    }

    /**
     * 找小于K个数的位置， 找不到返回-1 或者 26
     * @param wordCount
     * @return
     */
    private static int findLessThanKIndex(int[] wordCount, int k) {
        int index = -1;
        for (index = 0; index < wordCount.length; index++) {
            if (wordCount[index] != 0 && wordCount[index] < k) {
                return index;
            }
        }
        return index;
    }

    private static int[] calWordCount(String s) {
        int[] wordCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            wordCount[c - 'a']++;
        }
        return wordCount;
    }
}
