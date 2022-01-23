package com.bigcow.cn.code.other.unionfind;

public class FindCircleNum547Solution {

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        UnionFindSet unionFindSet = new UnionFindSet(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFindSet.unite(i, j);
                }
            }
        }
        return unionFindSet.getSetCount();
    }
}
