package com.bigcow.cn.code.tree.组合;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses93Solution {

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backtrace(s, "", res, 0, 0);
        return res;
    }

    private static void backtrace(String s, String path, List<String> res, int startIndex, int pointNum) {
        if (startIndex == s.length()) {
            if (pointNum == 4) {
                res.add(path.substring(0, path.length() - 1));
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (startIndex + i >= s.length()) {
                break;
            }
            int ipSegment = judgeIfIpSegment(s, startIndex, startIndex + i);
            if (ipSegment != -1) {
                backtrace(s, path + ipSegment + ".", res, startIndex + i + 1, pointNum + 1);
            }
        }
    }

    /**
     * 判断 s 的子区间 [left, right] 是否能够成为一个 ip 段
     * 判断的同时顺便把类型转了
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;

        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }

        // 转成 int 类型
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        if (res > 255) {
            return -1;
        }
        return res;
    }
}
