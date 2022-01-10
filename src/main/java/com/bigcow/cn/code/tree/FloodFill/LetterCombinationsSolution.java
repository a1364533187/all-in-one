package com.bigcow.cn.code.tree.FloodFill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsSolution {

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
        DFS(digits, digitsMap, res, new LinkedList<>());
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
            LinkedList<String> path) {
        if (path.size() == digits.length()) {
            res.add(arrToStr(path));
            return;
        }
        char c = digits.charAt(path.size());
        List<String> list = digitsMap.get(c);
        for (int i = 0; i < list.size(); i++) {
            path.add(list.get(i));
            DFS(digits, digitsMap, res, path);
            path.removeLast();
        }
    }

    private static String arrToStr(List<String> arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
        }
        return sb.toString();
    }
}
