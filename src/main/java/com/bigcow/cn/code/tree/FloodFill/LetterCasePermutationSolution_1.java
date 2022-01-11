package com.bigcow.cn.code.tree.FloodFill;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutationSolution_1 {

    public List<String> letterCasePermutation(String str) {
        if (null == str || "" == str) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        DFS(str, res, "");
        return res;
    }

    private void DFS(String str, List<String> res, String path) {
        if (path.length() == str.length()) {
            res.add(path);
            return;
        }
        char c = str.charAt(path.length());
        if (Character.isUpperCase(c)) {
            DFS(str, res, path + c);
            DFS(str, res, path + Character.toLowerCase(c));
        } else if (Character.isLowerCase(c)) {
            DFS(str, res, path + c);
            DFS(str, res, path + Character.toUpperCase(c));
        } else {
            DFS(str, res, path + c);
        }
    }
}
