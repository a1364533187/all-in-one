package com.bigcow.cn.hot100;

import java.util.List;

public class MergeTwoLists21Solution {

    // 迭代写法
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
                cur.next = null;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
                cur.next = null;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }

    // 递归写法
    public ListNode mergeTwoListsRecur(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoListsRecur(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecur(list1, list2.next);
            return list2;
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
}
