package com.bigcow.cn.code.bytedance.bfs;

import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStack895Solution {

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);//堆栈为 [5]
        freqStack.push(7);//堆栈是 [5,7]
        freqStack.push(5);//堆栈是 [5,7,5]
        freqStack.push(7);//堆栈是 [5,7,5,7]
        freqStack.push(4);//堆栈是 [5,7,5,7,4]
        freqStack.push(5);//堆栈是 [5,7,5,7,4,5]
        freqStack.pop();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
        freqStack.pop();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
        freqStack.pop();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
        freqStack.pop();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
    }
}

class FreqStack {

    /**
     * 1、肯定要有一个变量 maxFreq 记录当前栈中最高的频率是多少。
     *
     * 2、我们得知道一个频率 freq 对应的元素有哪些，且这些元素要有时间顺序。
     *
     * 3、随着 pop 的调用，每个 val 对应的频率会变化，所以还得维持一个映射记录每个 val 对应的 freq。
     */

    // 记录 FreqStack 中元素的最大频率
    int maxFreq = 0;
    // 记录 FreqStack 中每个 val 对应的出现频率，后文就称为 VF 表
    HashMap<Integer, Integer> valToFreq = new HashMap<>();
    // 记录频率 freq 对应的 val 列表，后文就称为 FV 表
    HashMap<Integer, Stack<Integer>> freqToVals = new HashMap<>();

    public FreqStack() {

    }

    public void push(int val) {
        // 修改 VF 表：val 对应的 freq 加一
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);
        // 修改 FV 表：在 freq 对应的列表加上 val
        freqToVals.putIfAbsent(freq, new Stack<>());
        freqToVals.get(freq).push(val);
        // 更新 maxFreq
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        // 修改 FV 表：pop 出一个 maxFreq 对应的元素 v
        Stack<Integer> vals = freqToVals.get(maxFreq);
        int v = vals.pop();
        // 修改 VF 表：v 对应的 freq 减一
        int freq = valToFreq.get(v) - 1;
        valToFreq.put(v, freq);
        // 更新 maxFreq
        if (vals.isEmpty()) {
            // 如果 maxFreq 对应的元素空了
            maxFreq--;
        }
        return v;
    }
}