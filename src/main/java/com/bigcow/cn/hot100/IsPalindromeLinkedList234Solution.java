package com.bigcow.cn.hot100;

public class IsPalindromeLinkedList234Solution {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        //快慢指针找到中间节点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时 slow 是中间节点
        ListNode l1 = head;
        ListNode backNode = slow.next;
        slow.next = null;
        ListNode l2 = reverse(backNode);
        return isSame(l1, l2);
    }

    // 可能l1 比 l2 多一个节点， 或者l2 比l1 多一个节点， 不过不重要
    private boolean isSame(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode reverseHead = reverse(next);
        next.next = head;
        return reverseHead;
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
}
