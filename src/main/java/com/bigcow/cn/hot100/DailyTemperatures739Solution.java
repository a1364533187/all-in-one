package com.bigcow.cn.hot100;

import java.util.Stack;

public class DailyTemperatures739Solution {

    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(temp);
    }

    // 单调递减栈 nb， 参考连接：https://leetcode-cn.com/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            // 保持栈是单调递减栈
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[1]) {
                // 栈里的元素需要出栈
                int[] e = stack.pop();
                res[e[0]] = i-e[0];
            }
            stack.push(new int[]{i, temperatures[i]});
        }

        return res;
    }
}
