package com.bigcow.cn.code.codetop;

public class ReverseLinkedListII92Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //找一个哨兵节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 找到left 节点
        ListNode preNode = findKNode(dummy, left - 1);
        ListNode leftNode = findKNode(dummy, left);

        // 找到right 节点
        ListNode rightNode = findKNode(dummy, right);
        ListNode rightNextNode = findKNode(dummy, right+1);
        System.out.println("preNode:" + preNode.val + " leftNode: " + leftNode.val + " rightNode: "
                + rightNode.val);
        preNode.next = null;
        rightNode.next = null;
        //反转单链表
        ListNode revHead = reverse(leftNode);
        leftNode.next = rightNextNode;
        preNode.next = revHead;
        return dummy.next;
    }

    private void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private ListNode findKNode(ListNode dummy, int k) {
        ListNode cur = dummy;
        while (k > 0) {
            System.out.println("cur: " + cur.val + " k:" + k);
            cur = cur.next;
            k--;
        }
        return cur;
    }

    private ListNode findTailNode(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    private ListNode reverse(ListNode leftNode) {
        if (leftNode == null || leftNode.next == null) {
            return leftNode;
        }
        ListNode next = leftNode.next;
        leftNode.next = null;
        ListNode revHead = reverse(next);
        next.next = leftNode;
        leftNode.next = null;
        return revHead;
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
