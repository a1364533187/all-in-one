package com.bigcow.cn.hot100;

public class RemoveNthFromEnd19Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head.next) {
            return null;
        }
        ListNode fast = head;
        while (n >= 0) {
            if (fast == null) { // 这里考虑的是//1 -> 2, n = 2的场景，也就是移除头节点
                return head.next;
            }
            fast = fast.next;
            n--;
        }
        //此时fast位置
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //到末尾了
        slow.next = slow.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
