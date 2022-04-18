package com.bigcow.cn.code.microsoft;

import java.util.ArrayList;
import java.util.List;

public class ParsingABooleanExpression1106Solution {

    public static void main(String[] args) {
        //        String exp = "!(f)";
        //        String exp = "!(t)";
        //        String exp = "|(f,t)";
        //        String exp = "&(t,f)";
        String exp = "|(&(t,f,t),!(t))";
        System.out.println(parseBoolExpr(exp));
    }

    public static boolean parseBoolExpr(String expression) {
        if (expression.equals("f")) {
            return false;
        } else if (expression.equals("t")) {
            return true;
        } else {
            char c = expression.charAt(0);
            String subExp = expression.substring(2, expression.length() - 1);
            // 将表达式分割成多个部分
            if (c == '|') {
                List<String> expressions = splitAndOrExpressions(subExp);
                return parseOrExpr(expressions);
            }
            if (c == '&') {
                List<String> expressions = splitAndOrExpressions(subExp);
                return parseAndExpr(expressions);
            }
            if (c == '!') {
                return parseFlipExpr(subExp);
            }
        }
        return false;
    }

    /**
     * |(f, t, f),t, t, split 时切开外层， 不动里层
     * @param expression
     * @return
     */
    private static List<String> splitAndOrExpressions(String expression) {
        List<String> splitExpressions = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '|' || c == '&' || c == '!') {
                int rightBracketIndex = findRightBracketIndex(expression, i + 1);
                splitExpressions.add(expression.substring(i, rightBracketIndex + 1));
                i = rightBracketIndex;
            } else if (c == 't' || c == 'f') {
                splitExpressions.add(expression.substring(i, i + 1));
            }
            i++; // 跳过,
        }

        return splitExpressions;
    }

    private static int findRightBracketIndex(String expression, int leftBracketIndex) {
        int leftBracketCount = 1;
        for (int i = leftBracketIndex + 1; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (leftBracketCount == 1 && c == ')') {
                return i;
            }
            if (c == '(') {
                leftBracketCount++;
            } else if (c == ')') {
                leftBracketCount--;
            }
        }
        return -1;
    }

    // 已经出现 AND 比如 &(|(f,t), f, t) 这里拿到的expressions 为  |(f,t)， f, t
    private static boolean parseAndExpr(List<String> expressions) {
        for (int i = 0; i < expressions.size(); i++) {
            String exp = expressions.get(i);
            boolean tmp = parseBoolExpr(exp);
            if (!tmp) {
                return false;
            }
        }
        return true;
    }

    // 已经出现 OR
    private static boolean parseOrExpr(List<String> expressions) {
        for (int i = 0; i < expressions.size(); i++) {
            String exp = expressions.get(i);
            boolean tmp = parseBoolExpr(exp);
            if (tmp) {
                return true;
            }
        }
        return false;
    }

    // 取反
    private static boolean parseFlipExpr(String expression) {
        return !parseBoolExpr(expression);
    }
}
