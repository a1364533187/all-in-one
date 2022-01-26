package com.bigcow.cn.code.tree.LinkedList;

public class AddTwoNumbers2Solution {

    public static void main(String[] args) {
        int[] nums = { 9, 9, 9, 9, 9, 9, 9 };
        int[] nums1 = { 9, 9, 9, 9 };
        ListNode l1 = buildLinkedList(nums);
        ListNode l2 = buildLinkedList(nums1);
        ListNode resHead = addTwoNumbers(l1, l2);
        printLinkedList(resHead);
    }

    private static ListNode buildLinkedList(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode nextNode = new ListNode(nums[i]);
            cur.next = nextNode;
            cur = cur.next;
        }
        return head;
    }

    private static void printLinkedList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.print("---" + cur.val);
            cur = cur.next;
        }
    }

    // https://leetcode-cn.com/problems/add-two-numbers/
    // 题解：https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0); // 不适合new ListNode 作为head时，采用dump node
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode cur = dump;
        int tenDigit = 0;
        while (cur1 != null || cur2 != null) {
            int cur1Val = cur1 == null ? 0 : cur1.val;
            int cur2Val = cur2 == null ? 0 : cur2.val;
            int val = cur1Val + cur2Val + tenDigit;
            int singleDigit;
            if (val >= 10) {
                singleDigit = val - 10;
                tenDigit = 1;
            } else {
                singleDigit = val;
                tenDigit = 0;
            }
            ListNode nextNode = new ListNode(singleDigit);
            cur.next = nextNode;
            cur = cur.next;
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        if (tenDigit == 1) {
            cur.next = new ListNode(1);
        }
        return dump.next;
    }

    static class ListNode {

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
}
