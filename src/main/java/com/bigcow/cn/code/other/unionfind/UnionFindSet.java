package com.bigcow.cn.code.other.unionfind;

/**
 * 参考文章：https://mp.weixin.qq.com/s/3DBREYfAveY-laQTSldpaw
 */
public class UnionFindSet {

    private int[] parents; //父节点

    private int setCount; //集合的个数

    private int[] sizes; //某个集合的个数

    public UnionFindSet(int N) {
        parents = new int[N];
        sizes = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }
        setCount = N;
    }

    private int root(int i) {
        while (i != parents[i])
            i = parents[i];
        return i;
    }

    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

    public void unite(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        if (sizes[i] > sizes[j]) {
            parents[j] = i;
            sizes[i] = sizes[i] + sizes[j];
        } else {
            parents[i] = j;
            sizes[j] = sizes[i] + sizes[j];
        }
        setCount--;
    }

    public int getSetCount() {
        return setCount;
    }
}
