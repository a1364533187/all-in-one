package com.bigcow.cn.code.tree.FloodFill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsSolution_1 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        if (null == digits || digits.equals("")) {
            return new ArrayList<>();
        }
        Map<Character, List<String>> digitsMap = new HashMap<Character, List<String>>() {

            {

                put('2', myNewArrayList("a", "b", "c"));
                put('3', myNewArrayList("d", "e", "f"));
                put('4', myNewArrayList("g", "h", "i"));
                put('5', myNewArrayList("j", "k", "l"));
                put('6', myNewArrayList("m", "n", "o"));
                put('7', myNewArrayList("p", "q", "r", "s"));
                put('8', myNewArrayList("t", "u", "v"));
                put('9', myNewArrayList("w", "x", "y", "z"));
            }
        };
        List<String> res = new ArrayList<>();
        DFS(digits, digitsMap, res, "");
        return res;
    }

    private static List<String> myNewArrayList(String... values) {
        List<String> list = new ArrayList<>();
        for (String value : values) {
            list.add(value);
        }
        return list;
    }

    private static void DFS(String digits, Map<Character, List<String>> digitsMap, List<String> res,
            String path) {
        if (path.length() == digits.length()) {
            res.add(path);
            return;
        }
        char c = digits.charAt(path.length());
        List<String> list = digitsMap.get(c);
        for (int i = 0; i < list.size(); i++) {
            DFS(digits, digitsMap, res, path + list.get(i)); //这里状态转换有每层递归来维护与还原， 可以对比自己维护与还原
        }
    }
}
