package com.bigcow.cn.code.中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *         作者：zohn-z
 *         链接：https://leetcode-cn.com/problems/find-median-from-data-stream/solution/qing-xi-tu-jie-jian-zhi-offer41-shu-ju-l-rpen/
 *         来源：力扣（LeetCode）
 *         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindMedianFromDataStream295Solution {

    // 维护大顶堆， 小顶堆
    PriorityQueue<Integer> maxHeap; // 放的都是较小的元素， 堆顶是最大的元素
    PriorityQueue<Integer> minHeap; // 放的是较大的元素，堆顶是最小的元素, minPeek > maxPeek, 并且维持minHeap 多一个或者0个元素

    public FindMedianFromDataStream295Solution() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minHeap = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public void addNum(int num) {
        // 长度为奇数时先放入小顶堆,重新排序后在插入到大顶堆
        if (maxHeap.size() < minHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            // 长度为偶数时先放入大顶堆,重新排序后在插入到小顶堆
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
