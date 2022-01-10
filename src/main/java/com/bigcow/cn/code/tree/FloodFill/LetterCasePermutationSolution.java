package com.bigcow.cn.code.tree.FloodFill;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutationSolution {

    public List<String> letterCasePermutation(String str) {
        if (null == str || "" == str) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        DFS(str, res, new LinkedList<>());
        return res;
    }

    private void DFS(String str, List<String> res, LinkedList<Character> path) {
        if (path.size() == str.length()) {
            res.add(arrToStr(path));
            return;
        }
        char c = str.charAt(path.size());
        if (Character.isUpperCase(c)) {
            path.add(c);
            DFS(str, res, path);
            path.removeLast();

            path.add(Character.toLowerCase(c));
            DFS(str, res, path);
            path.removeLast();
        } else if (Character.isLowerCase(c)) {
            path.add(c);
            DFS(str, res, path);
            path.removeLast();

            path.add(Character.toUpperCase(c));
            DFS(str, res, path);
            path.removeLast();
        } else {
            path.add(c);
            DFS(str, res, path);
            path.removeLast();
        }
    }

    private static String arrToStr(List<Character> arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
        }
        return sb.toString();
    }
}
