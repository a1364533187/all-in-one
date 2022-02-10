package com.bigcow.cn.code.string.window;

import java.util.LinkedList;

public class SlidingWindowMaximum239Solution {

    // 采用滑动窗口K + 双端队列
    // (和最小栈较像， 最小栈求下一个更大元素，是和栈顶相比， 这里双端队列是和队列首元素相比)
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 放置索引位置， 队列单调递减
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(0);
        // 前K - 1个元素，入queue
        for (int i = 1; i < k - 1; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.add(i);
        }
        int[] res = new int[nums.length - k + 1];
        int end = k - 1;
        while (end < nums.length) {
            while (!queue.isEmpty() && nums[end] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            if (!queue.isEmpty() && end - k == queue.getFirst()) {
                queue.removeFirst();
            }
            queue.add(end);
            res[end - k + 1] = nums[queue.getFirst()];
            end++;
        }
        return res;
    }
}
