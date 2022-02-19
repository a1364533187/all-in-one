package com.bigcow.cn.code.shopee;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs336Solution {

    public static void main(String[] args) {
        //        String[] words = { "abcd", "dcba", "lls", "s", "sssll" };
        String[] words = { "a", "" };
        System.out.println(palindromePairs(words));
    }

    /**
     * https://leetcode-cn.com/problems/palindrome-pairs/solution/qian-zhui-shu-jie-fa-by-dufre/
     * @param words
     * @return
     */
    public static List<List<Integer>> palindromePairs(String[] words) {
        Trie trie = new Trie();
        int emptyStringIndex = -1;
        // 构建trie 树
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                emptyStringIndex = i;
            }
            trie.insert(words[i], i);
        }

        List<List<Integer>> res = new ArrayList<>();
        // 匹配搜索
        for (int i = 0; i < words.length; i++) {
            if (emptyStringIndex != -1) {
                if (isPalindrome(words[i]) && i != emptyStringIndex) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(emptyStringIndex);
                    res.add(pair);
                }
            }
            List<Integer> palindromeList = trie.findPrefix(words[i]);
            for (int j = 0; j < palindromeList.size(); j++) {
                if (palindromeList.get(j) != i) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(palindromeList.get(j));
                    res.add(pair);
                }
            }
        }
        return res;
    }

    /**
     * 将字符串逆序构建前缀树
     */
    static class Trie {

        private Trie[] children;
        private int endIndex;
        private List<Integer> palindromeIndexList;

        Trie() {
            this.children = new Trie[26];
            this.endIndex = -1;
            palindromeIndexList = new ArrayList<>();
        }

        public void insert(String word, int index) {
            Trie root = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (isPalindrome(word.substring(0, i + 1))) {
                    root.palindromeIndexList.add(index);
                }
                char c = word.charAt(i);
                if (root.children[c - 'a'] == null) {
                    root.children[c - 'a'] = new Trie();
                }
                root = root.children[c - 'a'];
            }
            root.endIndex = index;
        }

        public List<Integer> findPrefix(String prefix) {
            Trie root = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (root.children[c - 'a'] == null) {
                    return new ArrayList<>();
                }
                root = root.children[c - 'a'];
            }
            if (root.endIndex != -1) {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(root.endIndex);
                indexList.addAll(root.palindromeIndexList);
                return indexList;
            }
            return root.palindromeIndexList;
        }
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}
