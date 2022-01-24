package com.bigcow.cn.code.other.lru;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    //get o(1)的时间
    private HashMap<Integer, Node> getHashMap;
    // put o(1)的时间
    private LinkedList<Node> putList = new LinkedList<>();

    LRUCache(int capacity) {
        this.getHashMap = new HashMap<>(capacity);
    }

    public int get(int k) {
        Node node = getHashMap.get(k);
        if (null == node) {
            return -1;
        }
        int val = node.getVal();
        //当前的node 移到头节点
        putList.remove(node);
        putList.addFirst(node);
        return val;
    }

    //如果k存在于Map, 会将k对应的node置于队列头，并更新value
    public void put(int k, int v) {
        Node node = getHashMap.get(k);
        if (null == node) {
            putList.addFirst(node);
        } else {
            //当前的node 移到头节点
            putList.remove(node);
            putList.addFirst(node);
        }
    }


    class Node {

        int k;
        int val;

        public Node(int k, int val) {
            this.k = k;
            this.val = val;
        }

        public int getK() {
            return k;
        }

        public int getVal() {
            return val;
        }
    }
}
