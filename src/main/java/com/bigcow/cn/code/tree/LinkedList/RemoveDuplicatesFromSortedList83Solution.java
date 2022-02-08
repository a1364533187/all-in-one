package com.bigcow.cn.code.tree.LinkedList;

public class RemoveDuplicatesFromSortedList83Solution {
    //
    //    public ListNode deleteDuplicates(ListNode head) {
    //        if (head == null || head.next == null) {
    //            return head;
    //        }
    //        ListNode slow = head;
    //        ListNode fast = head.next;
    //        while (fast != null) {
    //            if (fast.val == slow.val) {
    //                while (fast != null && fast.val == slow.val) {
    //                    fast = fast.next;
    //                }
    //                // fast == null 结束
    //                slow.next = fast;
    //            }
    //            if (fast != null) {
    //                fast = fast.next;
    //                slow = slow.next;
    //            }
    //        }
    //        return head;
    //    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
