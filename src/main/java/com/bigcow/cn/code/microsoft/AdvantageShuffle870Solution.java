package com.bigcow.cn.code.microsoft;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class AdvantageShuffle870Solution {

    public static void main(String[] args) {
        //        int[] nums1 = { 2, 7, 11, 15 }, nums2 = { 1, 10, 4, 11 };
        int[] nums1 = { 12, 24, 8, 32 }, nums2 = { 13, 25, 32, 11 };
        int[] res = advantageCount(nums1, nums2);
    }

    /**
     * 田忌赛马问题
     * 贪心：
     * 把 A 和 B 都排序
     * 从左至右遍历 A，若 a 比 剩余B 中最小的还要小，意味着它无法打败任何 剩余B 中元素，则将其随意赋予 剩余B 中最大的一个，同时将 剩余B 中最大的一个 pop 掉
     * 若 a 大于 剩余B 中最小的元素，则将其赋予 剩余B 中最小的元素，同时将 剩余B 中最小的元素 pop 掉
     *
     * java PriorityQueue 实现
     * https://leetcode-cn.com/problems/advantage-shuffle/solution/java-pai-xu-shuang-zhi-zhen-by-programme-wszf/
     * 作者：eloise-1
     * 链接：https://leetcode-cn.com/problems/advantage-shuffle/solution/si-lu-qing-xi-tan-xin-by-eloise-1-y91t/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        PriorityQueue<int[]> n2IncreasePriorityQueue = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 建立数组索引 和 基于数目排序的映射关系
        for (int i = 0; i < nums2.length; i++) {
            n2IncreasePriorityQueue.add(new int[] { nums2[i], i });
        }
        // 将PrirityQueue 变成双端队列
        LinkedList<int[]> queue = new LinkedList<>();
        while (!n2IncreasePriorityQueue.isEmpty()) {
            queue.add(n2IncreasePriorityQueue.poll());
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int[] first = queue.getFirst();
            if (first[0] < nums1[i]) {
                res[first[1]] = nums1[i];
                queue.pollFirst();
            } else {
                int[] last = queue.pollLast();
                res[last[1]] = nums1[i];
            }
        }
        return res;
    }
}
