package com.bigcow.cn.list;

public class ReverseNodesInKGroup25Solution {

    // 1->2->3->4->5->6->7    k = 3
    // 3->2->1->6->5->4->7

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        ListNode head = buildLinkedList(nums);
        ListNode newHead = reverseKGroup(head, 3);
        printLinkedList(newHead);
    }

    private static ListNode buildLinkedList(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0], null);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    private static void printLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print("--->" + cur.val);
            cur = cur.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = findKNode(head, k);
        if (cur == null) { // 不足K个的链表，直接返回
            return head;
        }
        ListNode nextTail = cur.next;
        cur.next = null;
        ListNode newHead = reverse(head);
        ListNode nextReverse = reverseKGroup(nextTail, k);
        head.next = nextReverse;
        return newHead;
    }

    private static ListNode findKNode(ListNode head, int k) {
        ListNode cur = head;
        while (k > 1 && cur != null) {
            cur = cur.next;
            k--;
        }
        return cur;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        ListNode newHead = reverse(cur);
        cur.next = head;
        return newHead;
    }
}
