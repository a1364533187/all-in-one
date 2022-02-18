package com.bigcow.cn.code.string.window;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDnaSequences187Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            String str = s.substring(i - 10, i);
            if (set.contains(str)) {
                res.add(str);
            }
            set.add(str);
        }
        return new ArrayList<>(res);
    }
}
