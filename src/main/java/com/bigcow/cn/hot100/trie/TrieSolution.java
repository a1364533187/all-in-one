package com.bigcow.cn.hot100.trie;

public class TrieSolution {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("happy");
        trie.insert("hi");

        //
        System.out.println(trie.search("hell"));
        System.out.println(trie.startsWith("hell"));
        System.out.println(trie.search("hello"));
    }
}
