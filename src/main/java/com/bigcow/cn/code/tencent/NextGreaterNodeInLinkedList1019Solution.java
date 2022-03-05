package com.bigcow.cn.code.tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterNodeInLinkedList1019Solution {

    public int[] nextLargerNodes(ListNode head) {
        // 遍历链表知道长度
        Map<ListNode, Integer> map = countList(head);
        int[] res = new int[map.size()];
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                ListNode node = stack.pop();
                res[map.get(node)] = cur.val;
            }
            stack.push(cur);
            cur = cur.next;
        }
        return res;
    }

    private Map<ListNode, Integer> countList(ListNode head) {
        if (head == null) {
            return new HashMap<>();
        }
        ListNode cur = head;
        Map<ListNode, Integer> map = new HashMap<>();
        int count = 0;
        while (cur != null) {
            map.put(cur, count);
            count++;
            cur = cur.next;
        }
        return map;
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
