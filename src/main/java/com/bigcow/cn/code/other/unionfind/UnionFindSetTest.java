package com.bigcow.cn.code.other.unionfind;

class UnionFindSetTest {

    public static void main(String[] args) {
        UnionFindSet unionFindSet = new UnionFindSet(6);
        unionFindSet.unite(7,8);
        unionFindSet.unite(9, 11);
        unionFindSet.unite(7, 11);
        unionFindSet.unite(8,10);

        System.out.println(unionFindSet.getSetCount());
    }
}