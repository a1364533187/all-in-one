package com.bigcow.cn.code.tree.tree;

public class ConvertSortedListToBinarySearchTree109Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode[] partition = partitionList(head);
        if (partition[1] == null) {
            return null;
        }
        TreeNode root = new TreeNode(partition[1].val);
        if (partition[0] != partition[1]) {
            root.left = sortedListToBST(partition[0]);
        }
        if (partition[1] != partition[2]) {
            root.right = sortedListToBST(partition[2]);
        }
        return root;
    }

    // 找到链表的中间节点，快慢指针, 然后记录左链表头节点， 右链表头节点， 以及中间节点
    // int[0] left
    // int[1] mid
    // int[1] right
    public ListNode[] partitionList(ListNode head) {
        if (head == null || head.next == null) {
            return new ListNode[] { null, head, null };
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            pre = pre.next;
            fast = fast.next.next;
        }
        dummy.next = null;
        ListNode right = slow.next;
        slow.next = null;
        pre.next = null;
        System.out.println("pre: " + pre.val + "head:" + head.val + "slow: " + slow.val + "right: "
                + right.val);
        return new ListNode[] { head, slow, right };
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
