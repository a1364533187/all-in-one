package com.bigcow.cn.code.tencent;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference1218Solution {

    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, 8, 5, 3, 4, 2, 1 };
        System.out.println(longestSubsequence1(arr, -2));
    }

    // 超出时间限制 O(N*N)
    public static int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == difference) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

    // 尝试 O(N)
    public static int longestSubsequence1(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i] - difference;
            if (valueIndexMap.containsKey(key)) {
                dp[i] = dp[valueIndexMap.get(key)] + 1;
                max = Math.max(dp[i], max);
            }
            valueIndexMap.put(arr[i], i);
        }
        return max;
    }
}
