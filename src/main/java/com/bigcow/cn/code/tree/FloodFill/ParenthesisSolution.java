package com.bigcow.cn.code.tree.FloodFill;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParenthesisSolution {

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, new LinkedList<>(), 0, 0, res);
        return res;
    }

    private static void backtrack(int n, LinkedList<Character> path, int leftCount, int rightCount,
            List<String> memSet) {
        if (path.size() == 2 * n && leftCount == n && rightCount == n) {
            memSet.add(arrToStr(path));
            return;
        }
        if (leftCount > n || rightCount > n || leftCount < rightCount) {
            return;
        }
        path.add('(');
        backtrack(n, path, leftCount + 1, rightCount, memSet);
        path.removeLast();
        path.add(')');
        backtrack(n, path, leftCount, rightCount + 1, memSet);
        path.removeLast();

    }

    private static String arrToStr(List<Character> arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
        }
        return sb.toString();
    }
}
