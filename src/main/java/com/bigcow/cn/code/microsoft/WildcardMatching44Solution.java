package com.bigcow.cn.code.microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WildcardMatching44Solution {

    public static void main(String[] args) {
        //        String s = "aa", p = "*";
        //        String s = "cb", p = "?a";
        String s = "adceb", p = "*a*b";
        //        String s = "acdcb", p = "a*c?b";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private static Map<Pair, Boolean> memorizeMap = new HashMap<>();

    public static boolean isMatch(String s, int i, String p, int j) {
        Pair pair = new Pair(i, j);
        if (memorizeMap.containsKey(pair)) {
            return memorizeMap.get(pair);
        }
        if (j == p.length()) {
            return i == s.length();
        }
        if (i == s.length()) {
            // 如果结尾都是*,那也没问题
            for (; j < p.length(); j++) {
                if (p.charAt(j) != '*') {
                    return false;
                }
            }
            return true;
        }

        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            res = isMatch(s, i + 1, p, j + 1);
        } else {
            if (p.charAt(j) == '*') {
                // 匹配 1个或者多个字符个字符
                boolean var1 = isMatch(s, i + 1, p, j);
                // 匹配 0个字符
                boolean var2 = isMatch(s, i, p, j + 1);
                res = var1 || var2;
            } else { // s.charAt(i) != p.charAt(j)
                res = false;
            }
        }
        Pair pairPut = new Pair(i, j);
        memorizeMap.put(new Pair(i, j), res);
        return memorizeMap.get(pairPut);
    }

    //一个辅助类，用来包装字符串S的下标i，和模式串P的下标j
    //把i和j两个int作为一个整体封装为一个对象，hashmap的key会用到这个对象
    static class Pair {

        private int i;
        private int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            Pair other = (Pair) o;
            return this.i == other.i && this.j == other.j;
        }

        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
