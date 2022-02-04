package com.bigcow.cn.code.other.unionfind.unionfindreduction;

public class UnionFindQuickFind {

    private int[] parent;

    /**
     * 这里实现的并查集查找的是对象范围0 ～ N
     * @param N
     */
    public UnionFindQuickFind(int N) {
        this.parent = new int[N];
        for (int i = 0; i < N; i++) {
            this.parent[i] = i;
        }
    }

    public void union(int p, int q) {
        int pParent = parent[p];
        // O(N) 的时间复杂度
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == pParent) {
                parent[i] = parent[q];
            }
        }
    }

    public boolean find(int p, int q) {
        return parent[p] == parent[q];
    }

}
