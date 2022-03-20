package com.bigcow.cn.code.bytedance.bfs;

public class KthSmallestInLexicographicalOrder440Solution1 {

    public int findKthNumber(int n, int k) {
        long pCount = 1; // 表示当前有多少个元素
        int prefix = 1; // 当前访问的哪一个元素
        while (pCount < k) {
            int count = getPrefixCount(prefix, n);
            if (pCount + count > k) { // 说明在这个prefix下
                prefix = prefix * 10;
                pCount++;
            } else {
                pCount = pCount + count;
                prefix = prefix + 1;
            }
        }
        return prefix;
    }

    public int getPrefixCount(int prefix, int n) {
        long cur = prefix;
        long next = cur + 1;
        int count = 0;
        while (cur <= n) {
            count += Math.min(n + 1, next) - cur;
            next = next * 10;
            cur = cur * 10;
        }
        return count;
    }
}
