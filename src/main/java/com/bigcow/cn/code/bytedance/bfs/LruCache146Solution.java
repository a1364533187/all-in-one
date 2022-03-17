package com.bigcow.cn.code.bytedance.bfs;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache146Solution {
}

class LRUCache {

    private LruDelegateLinkedHashMap<Integer, Integer> delegate;

    public LRUCache(int capacity) {
        this.delegate = new LruDelegateLinkedHashMap<>(capacity);
    }

    public int get(int key) {
        Integer val = this.delegate.get(key);
        return val == null ? -1 : val;
    }

    public void put(int key, int value) {
        this.delegate.put(key, value);
    }

    class LruDelegateLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

        private int capacity;

        LruDelegateLinkedHashMap(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }
}