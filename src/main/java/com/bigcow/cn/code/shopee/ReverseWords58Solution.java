package com.bigcow.cn.code.shopee;

public class ReverseWords58Solution {

    public static void main(String[] args) {
        String str = "I am a student. ";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s) {
        String ss = s.trim();
        String reverse = new StringBuilder(ss).reverse().toString();
        // 按照空格分割
        String[] splits = reverse.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            if (splits[i].equals("")) {
                continue;
            }
            res.append(" " + new StringBuilder(splits[i]).reverse().toString());
        }
        return res.toString().trim();
    }


}
