package com.bigcow.cn.hot100;

public class IntersectionOfTwoLinkedLists160Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 统计headA count
        int aCount = 0;
        ListNode curA = headA;
        while (curA != null) {
            aCount++;
            curA = curA.next;
        }
        // 统计headB count
        int bCount = 0;
        ListNode curB = headB;
        while (curB != null) {
            bCount++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if (bCount > aCount) {
            int diff = bCount - aCount;
            while (diff > 0) {
                diff--;
                curB = curB.next;
            }
        } else {
            int diff = aCount - bCount;
            while (diff > 0) {
                diff--;
                curA = curA.next;
            }
        }

        // 找链表的焦点
        return findIntersectionNode(curA, curB);
    }

    private ListNode findIntersectionNode(ListNode curA, ListNode curB) {
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}