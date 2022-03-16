package com.bigcow.cn.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists23Solution {

    /**
     * 采用优先队列实现
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,
                (o1, o2) -> {
                    return o1.val -o2.val;
                });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }

}
