package com.bigcow.cn.list;

public class RemoveDuplicatesFromSortedListII82Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 定义dummy 节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy.next;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next == fast) { // 没有重复节点
                fast = fast.next;
                slow = slow.next;
            } else { // 有重复节点
                fast = fast.next;
                slow.next = fast;
            }
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
