package com.bigcow.cn.hot100;

public class MergeKLists23Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dumpy = new ListNode(0);
        ListNode cur = dumpy;
        while (true) { // 找到了minListNode
            NodePair nodePair = findMinValue(lists);
            if (null == nodePair) {
                break;
            }
            // node pair 不为空，说明找到了minValue， 开始搞事情
            cur.next = nodePair.cur;
            cur = cur.next;
            lists[nodePair.key] = nodePair.cur.next;
            cur.next = null;
        }
        return dumpy.next;
    }

    // 从lists 中找到最小值,找不到返回null
    public NodePair findMinValue(ListNode[] lists) {
        ListNode minListNode = null;
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            if (null != lists[i] && minValue > lists[i].val) {
                minValue = lists[i].val;
                minListNode = lists[i];
                minIndex = i;
            }
        }
        return minListNode == null ? null : new NodePair(minIndex, minListNode);
    }

    class NodePair {

        Integer key;
        ListNode cur;

        public NodePair(Integer key, ListNode cur) {
            this.key = key;
            this.cur = cur;
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
