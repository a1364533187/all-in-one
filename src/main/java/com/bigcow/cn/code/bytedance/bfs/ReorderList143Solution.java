package com.bigcow.cn.code.bytedance.bfs;

public class ReorderList143Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 快慢指针找到中间节点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow 是中点
        ListNode two = slow.next;
        slow.next = null;
        // 反转
        ListNode l2 = reverse(two);
        merge(head, l2);
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverse(next);
        next.next = head;
        return newHead;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        boolean addL1 = true;
        while (l1 != null && l2 != null) {
            if (addL1) {
                cur.next = l1;
                l1 = l1.next;
                addL1 = false;
            } else {
                cur.next = l2;
                l2 = l2.next;
                addL1 = true;
            }
            cur = cur.next;
            cur.next = null;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
