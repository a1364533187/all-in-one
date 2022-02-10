package com.bigcow.cn.code.probability.reservoirsampling;

import java.util.ArrayList;
import java.util.List;

public class LinkedListRandomNode382Solution {

    private List<Integer> list;

    public LinkedListRandomNode382Solution(ListNode head) {
        this.list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

    }

    public int getRandom() {
        int i = (int) Math.random() * list.size();
        return list.get(i);
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
