package com.bigcow.cn.code.shopee;

public class RotateString796Solution {

    public static void main(String[] args) {
        String s = "abcde", goal = "abced";
        System.out.println(rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            return true;
        }
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {

            // s
            String sL = s.substring(0, i + 1);
            String sR = s.substring(i + 1);

            //goal
            String gL = goal.substring(0, len - i - 1);
            String gR = goal.substring(len - i - 1, len);

            if (sL.equals(gR) && sR.equals(gL)) {
                return true;
            }
        }
        return false;
    }
}
