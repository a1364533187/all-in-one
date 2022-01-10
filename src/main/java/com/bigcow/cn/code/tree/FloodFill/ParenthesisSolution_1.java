package com.bigcow.cn.code.tree.FloodFill;

import java.util.ArrayList;
import java.util.List;

public class ParenthesisSolution_1 {

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, "", 0, 0, res);
        return res;
    }

    private static void backtrack(int n, String path, int leftCount, int rightCount,
            List<String> memSet) {
        if (leftCount == n && rightCount == n) {
            memSet.add(path);
            return;
        }
        if (leftCount > n || rightCount > n || leftCount < rightCount) {
            return;
        }
        //不就是 递归 root.left 与 root.right吗？
        backtrack(n, path + "(", leftCount + 1, rightCount, memSet);
        backtrack(n, path + ")", leftCount, rightCount + 1, memSet);

    }

    private static String arrToStr(List<Character> arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
        }
        return sb.toString();
    }
}
