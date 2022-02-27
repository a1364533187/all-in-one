package com.bigcow.cn.code.中位数;

public class MedianFinderTest {

    public static void main(String[] args) {
        FindMedianFromDataStream295Solution solution = new FindMedianFromDataStream295Solution();
        solution.addNum(1);
        solution.addNum(2);
        solution.addNum(3);
        System.out.println(solution.findMedian());
    }
}
