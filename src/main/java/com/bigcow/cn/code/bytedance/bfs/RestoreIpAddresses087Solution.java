package com.bigcow.cn.code.bytedance.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses087Solution {

    public static void main(String[] args) {
        //        String s = "25525511135";
        //        String s = "0000";
        String s = "10203040";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) { // 如果IP 地址超过12 位， 也不是有效的IP 地址
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfs(s, res, new LinkedList<>(), 0);
        return res;
    }

    private static void dfs(String s, List<String> res, LinkedList<String> path, int start) {
        if (start == s.length()) {
            if (path.size() == 4) {
                String p1 = path.get(0);
                for (int i = 1; i < 4; i++) {
                    p1 += "." + path.get(i);
                }
                res.add(p1);
            }
            return;
        }
        // 每次最多取 0 - 3个字符
        for (int i = 0; i < 3; i++) {
            if (start + i >= s.length() || !isValidIpSegment(s, start, start + i)) {
                continue;
            }
            path.add(s.substring(start, start + i + 1));
            dfs(s, res, path, start + i + 1);
            path.removeLast();
        }
    }

    private static boolean isValidIpSegment(String s, int start, int end) {
        if (s.charAt(start) == '0' && end - start >= 1) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (s.charAt(i) - '0');
            } else {
                return false;
            }
        }
        return num >= 0 && num <= 255;
    }
}
