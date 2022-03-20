package com.bigcow.cn.code.bytedance.bfs;

public class RegularExpressionMatching10Solution {

    //    /**
    //     * 对于字符串 s 来说，没有特殊字符，当前问题中字符只会是字母，但是对于 p 来说，我们需要考虑两个特殊符号，还有字母，这里列举所有的可能，如果说当前的子问题是 s[i,…n] 和 p[j…m]:
    //     *
    //     * s[i] == p[j]，子问题成立与否取决于子问题 s[i+1,…n] 和 p[j+1,…m]
    //     *
    //     * p[j] == '.'，子问题成立与否取决于子问题 s[i+1,…n] 和 p[j+1,…m]
    //     *
    //     * p[j+1] == '*'，s[i] != p[j]，子问题成立与否取决于子问题 s[i,…n] 和 p[j+2,…m]
    //     *
    //     * p[j+1] == '*'，s[i] == p[j]，子问题成立与否取决于子问题 s[i+1,…n] 和 p[j,…m]
    //     * @param s
    //     * @param p
    //     * @return
    //     */
    //    public boolean isMatch(String s, String p) {
    //        if (s.equals(p)) {
    //            return true;
    //        }
    //
    //        boolean isFirstMatch = false;
    //        if (!s.isEmpty() && !p.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
    //            isFirstMatch = true;
    //        }
    //
    //        if (p.length() >= 2 && p.charAt(1) == '*') {
    //            // 看 s[i,...n] 和 p[j+2,...m] 或者是 s[i+1,...n] 和 p[j,...m]
    //            return isMatch(s, p.substring(2))
    //                    || (isFirstMatch && isMatch(s.substring(1), p));
    //        }
    //
    //        // 看 s[i+1,...n] 和 p[j+1,...m]
    //        return isFirstMatch && isMatch(s.substring(1), p.substring(1));
    //    }

    public static void main(String[] args) {
        //        String s = "aa", p = "a*";
        String s = "aab", p = "c*a*b";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    /**
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247486742&idx=1&sn=73d38d4d8b51af81b782c6d11fa5e21e&chksm=9bd7f31eaca07a083c23efbc60b74ff0b093efb92f43bf1e4366ae00394a7385ea73ac62b78d&mpshare=1&scene=1&srcid=0320wuNyxoYB0m7BwYpXqWZ7&sharer_sharetime=1647742163457&sharer_shareid=f03c4319346a005bf50732273ea98e4c&exportkey=AZA%2B8QHM9HPs8wXc6ewGM%2BY%3D&acctmode=0&pass_ticket=ybP3uxZ%2Fg4qGO9AldJaEd9awDw0pCKrEoRdWiKpnWlGFUNYZ%2BLf0nOCPLB9nWie%2F&wx_header=0#rd
     * @param s
     * @param i
     * @param p
     * @param j
     * @return
     */
    public static boolean isMatch(String s, int i, String p, int j) {
        if (j == p.length()) { // j 到尾部
            return i == s.length();
        }
        if (i == s.length()) { // i 到尾部
            // 比如 s = "a", p = 'ab*c*', 空串匹配b*c*
            if ((p.length() - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < p.length(); j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                res = isMatch(s, i, p, j + 2) // 匹配 0 次
                        || isMatch(s, i + 1, p, j); //匹配1次 或者多次
            } else { // 不是 * 号
                res = isMatch(s, i+1, p, j + 1);
            }
        } else {
            // 匹配 0 次 s[i]
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                res = isMatch(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        return res;
    }
}
