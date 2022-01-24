package com.bigcow.cn.code.other.lru;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 参考文章：https://note.youdao.com/old-web/#/file/recent/note/WEB31c7ae96555869db28af57e6eca9c65b/?search=LRU
 */
public class LRUCache {

    //get o(1)的时间
    private HashMap<Integer, Node> getHashMap;
    // put o(1)的时间
    private LinkedList<Node> putList = new LinkedList<>();
    // 记录容量
    private int capacity;

    LRUCache(int capacity) {
        this.getHashMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int k) {
        Node node = getHashMap.get(k);
        if (null == node) {
            return -1;
        }
        int val = node.getVal();
        //当前的node 移到头节点
        putList.remove(node); // 这个可能是O(N)的复杂度
        putList.addFirst(node);
        return val;
    }

    //如果k存在于Map, 会将k对应的node置于队列头，并更新value
    public void put(int k, int v) {
        Node addNode = new Node(k, v);
        Node node = getHashMap.get(k);
        if (null == node) {
            //新增节点时，判断容量
            if (putList.size() >= capacity) {
                Node rmNode = putList.removeLast();
                getHashMap.remove(rmNode.getK());
            }
            // 直接加到头节点
            putList.addFirst(addNode);
            getHashMap.put(k, addNode);
        } else {
            //当前的node 移到头节点
            putList.remove(node);
            putList.addFirst(addNode);
            getHashMap.put(k, addNode);
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