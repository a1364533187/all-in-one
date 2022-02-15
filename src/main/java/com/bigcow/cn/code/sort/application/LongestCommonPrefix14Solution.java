package com.bigcow.cn.code.sort.application;

public class LongestCommonPrefix14Solution {

    public String longestCommonPrefix(String[] strs) {
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return strs[start];
        }
        int mid = start + (end - start) / 2;
        String left = longestCommonPrefix(strs, start, mid);
        String right = longestCommonPrefix(strs, mid + 1, end);
        return merge(left, right);
    }

    public String merge(String left, String right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        int i = 0;
        for (i = 0; i < left.length() && i < right.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                break;
            }
        }
        return left.substring(0, i);
    }

}
