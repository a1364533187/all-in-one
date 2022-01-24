package com.bigcow.cn.code.other.lru;

public class LruCacheTest {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println("---" + lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println("---" + lruCache.get(2));

    }
}
