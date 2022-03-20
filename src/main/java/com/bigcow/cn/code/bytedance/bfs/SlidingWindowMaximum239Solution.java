package com.bigcow.cn.code.bytedance.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum239Solution {

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int[] res = maxSlidingWindow(arr, 4);
        for (int i = 0; i < res.length; i++) {
            System.out.print("---" + res[i]);
        }
    }

    /**
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488087&idx=1&sn=673aa4e8deb942b951948650928c336e&chksm=9bd7ec5faca06549ba6176540fef04f93c1c9f55b303106688b894a2029e00b8cce1a9ba57a4&scene=178&cur_album_id=2121993002939219969#rd
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先把窗口的前 k - 1 填满
                window.push(nums[i]);
            } else {
                // 窗口开始向前滑动
                // 移入新元素
                window.push(nums[i]);
                // 将当前窗口中的最大元素记入结果
                res.add(window.max());
                // 移出最后的元素
                window.pop(nums[i - k + 1]);
            }
        }
        // 将 List 类型转化成 int[] 数组作为返回值
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}

/* 单调队列的实现 */
class MonotonicQueue {

    LinkedList<Integer> q = new LinkedList<>();

    public void push(int n) {
        // 将小于 n 的元素全部删除
        while (!q.isEmpty() && q.getLast() < n) {
            q.pollLast();
        }
        // 然后将 n 加入尾部
        q.addLast(n);
    }

    public int max() {
        return q.getFirst();
    }

    public void pop(int n) {
        if (n == q.getFirst()) {
            q.pollFirst();
        }
    }
}
