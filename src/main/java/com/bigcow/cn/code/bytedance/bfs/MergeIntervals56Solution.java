package com.bigcow.cn.code.bytedance.bfs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals56Solution {

    public static void main(String[] args) {
        //        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals = { { 1, 4 }, { 4, 5 } };
        System.out.println(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] compare = res.getLast();
            if (compare[1] >= intervals[i][0]) {
                compare[1] = Math.max(compare[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
