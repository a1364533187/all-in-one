package com.bigcow.cn.code.other.unionfind;

public class FindRedundantConnection684Solution {

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int[] res = findRedundantConnection(edges);
        for (int i = 0; i < res.length; i++) {
            System.out.println("---" + res[i]);
        }
    }

    public static int[] findRedundantConnection(int[][] edges) {
        UnionFindSet unionFindSet = new UnionFindSet(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            boolean isConnected = unionFindSet.find(edges[i][0], edges[i][1]);
            if (isConnected) {
                return new int[] { edges[i][0], edges[i][1] };
            } else {
                unionFindSet.unite(edges[i][0], edges[i][1]);
            }
        }
        return new int[] {};
    }
}
