package com.bigcow.cn.code.shopee;

public class StringWithoutAAAOrBBB984Solution {

    public String strWithout3a3b(int a, int b) {
        StringBuilder res = new StringBuilder();
        while (a > 0 && b > 0) {
            int len = res.length();
            // res 有2个a， 必须b
            if (len >= 2 && res.charAt(len - 1) == 'a' && res.charAt(len - 2) == 'a') {
                res.append("b");
                b--;
            } else if (len >= 2 && res.charAt(len - 1) == 'b' && res.charAt(len - 2) == 'b') {
                res.append("a");
                a--;
            } else if (a > b) {
                if (a >= 2) {
                    res.append("aa");
                    a = a - 2;
                } else {
                    res.append("a");
                    a = a - 1;
                }
            } else if (a < b) {
                if (b >= 2) {
                    res.append("bb");
                    b = b - 2;
                } else {
                    res.append("b");
                    b = b - 1;
                }
            } else { // a == b
                if (a == 0 && b == 0) {
                    break;
                } else if (a == 0 && b > 0) {
                    res.append("b");
                    b--;
                } else if (a > 0 && b == 0) {
                    res.append("a");
                    a--;
                } else {
                    res.append("a");
                    a--;
                }

            }
        }

        while (a > 0) {
            res.append("a");
            a--;
        }
        while (b > 0) {
            res.append("b");
            b--;
        }
        return res.toString();
    }
}
