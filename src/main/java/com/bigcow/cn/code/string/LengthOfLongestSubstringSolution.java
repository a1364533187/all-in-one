package com.bigcow.cn.code.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstringSolution {

    // https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/java-on-dong-tai-gui-hua-si-lu-qing-xi-z-w2ji/
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));

    }

    /**
     * 解题思路
     * 若计算以下标 n 作为结尾的最大不重复子串， 首先要判断第 n 位的字符有没有出现过。
     * 这时就有两种情况 "存在字符重复"，"字符不重复"
     *
     *
     * 字符不重复：最大子串长度 = 上一位的最大子串长度 + 1
     * f(n) = f(n - 1) + 1
     *
     * 存在字符重复：最大子串长度 = 现在的位置 - 相同字符上一次出现的位置
     * f(n) = index - lastIndex
     * 两个状态转移方程使用场景
     * 当第 n 位的字符若存在重复且 f(n - 1) + 1 大于 index - lastIndex
     * 因为当前位置最大不重复子串长度不可能超过 index - lastIndex，所以子串长度就是 index - lastIndex。
     * 其余情况以 f(n) = f(n - 1) + 1 处理
     *
     * 结论
     * 权衡两种情况两者的最小值即为 "最大不重复子串"，那么最终状态转移公式可变成
     *
     *
     * f(n) = Math.min(index - lastIndex， f (n - 1) + 1)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int last = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int lastIndex = charIndexMap.getOrDefault(c, -1);
            last = Math.min(i - lastIndex, last + 1);
            len = Math.max(last, len);
            charIndexMap.put(c, i);
        }
        return len;
    }

    // 不好的实现
    //双指针 + 滑动窗
//    public static int lengthOfLongestSubstring(String s) {
//        if (null == s || s.isEmpty()) {
//            return 0;
//        }
//        Set<Character> win = new HashSet<>();
//        int start = 0;
//        int end = 0;
//        int len = 0;
//        while (end < s.length()) {
//            char c = s.charAt(end);
//            while (win.contains(c)) {
//                if (start < s.length()) {
//                    win.remove(s.charAt(start));
//                    start++;
//                }
//            }
//            win.add(c);
//            end++;
//            len = Math.max(win.size(), len);
//        }
//        return Math.max(win.size(), len);
//    }
}
