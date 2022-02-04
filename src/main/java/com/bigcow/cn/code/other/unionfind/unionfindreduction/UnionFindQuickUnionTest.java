package com.bigcow.cn.code.other.unionfind.unionfindreduction;

public class UnionFindQuickUnionTest {

    public static void main(String[] args) {
        // 查找的元素为0 ~ N,  总共 0～5， 6个元素  [1, 2], [3, 5],[1,5], [0, 4]
        UnionFindQuickUnion unionFindQuickUnion = new UnionFindQuickUnion(6);
        unionFindQuickUnion.union(1, 2);
        unionFindQuickUnion.union(3, 5);
        unionFindQuickUnion.union(1, 5);
        unionFindQuickUnion.union(0, 4);

        System.out.println(unionFindQuickUnion.find(2, 5));

        System.out.println(unionFindQuickUnion.find(0, 5));
    }
}
