package com.bigcow.cn.code.other.unionfind.unionfindreduction;

public class UnionFindQuickFindTest {

    public static void main(String[] args) {
        // 查找的元素为0 ~ N,  总共 0～5， 6个元素  [1, 2], [3, 5],[1,5], [0, 4]
        UnionFindQuickFind unionFindQuickFind = new UnionFindQuickFind(6);
        unionFindQuickFind.union(1,2);
        unionFindQuickFind.union(3,5);
        unionFindQuickFind.union(1,5);
        unionFindQuickFind.union(0,4);

        System.out.println(unionFindQuickFind.find(2,5));

        System.out.println(unionFindQuickFind.find(0,5));
    }
}
