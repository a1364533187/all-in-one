package com.bigcow.cn.list.链表是否有环_环的长度_环的起点;

public class DetectCycleSolution {

    public ListNode detectCycle(ListNode head) {
        if (!hasCycle(head)) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // 找到成环链表的节点
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
