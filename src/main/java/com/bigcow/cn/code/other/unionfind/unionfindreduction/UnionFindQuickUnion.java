package com.bigcow.cn.code.other.unionfind.unionfindreduction;

public class UnionFindQuickUnion {

    private int[] parent;

    /**
     * 这里实现的并查集查找的是对象范围0 ～ N
     * @param N
     */
    public UnionFindQuickUnion(int N) {
        this.parent = new int[N];
        for (int i = 0; i < N; i++) {
            this.parent[i] = i;
        }
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        parent[pRoot] = qRoot;
    }

    // union 和 find 都需要root 函数
    private int root(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    public boolean find(int p, int q) {
        return root(p) == root(q);
    }
}
