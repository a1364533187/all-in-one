package com.bigcow.cn.code.shopee;

import java.util.HashMap;

public class CopyListWithRandomPointer138Solution {

    /**
     * 带随机指针的hashmap复制
     * https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/liang-chong-shi-xian-tu-jie-138-fu-zhi-dai-sui-ji-/
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> nodeMapping = new HashMap<>();
        Node dummy = new Node(0);
        dummy.next = head;
        Node cur = head;

        // 构建链表， 不带随机节点
        Node dummyNew = new Node(0);
        Node preNew = dummyNew;
        while (cur != null) {
            Node curNew = new Node(cur.val);
            preNew.next = curNew;
            preNew = curNew;

            nodeMapping.put(cur, curNew);

            cur = cur.next;
            curNew = curNew.next;
        }

        // 构建链表， 带随机节点
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                Node randomStart = nodeMapping.get(cur);
                Node randomEnd = nodeMapping.get(cur.random);
                randomStart.random = randomEnd;
            }
            cur = cur.next;
        }

        return dummyNew.next;
    }
}

class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
