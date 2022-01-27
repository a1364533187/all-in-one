package com.bigcow.cn.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals56Solution {

    public static void main(String[] args) {
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] res = merge(intervals);
    }

    //intervals = [[1,3],[2,6],[8,10],[15,18]]
    public static int[][] merge(int[][] intervals) {
        //按照首位数字排序后
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //比较每个resList最末尾的区间和下一个区间的开头位置， 如果>, 合并区间， 如果小于，增加新的区间段
        List<int[]> resList = new ArrayList<>();
        resList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] tempArr = resList.get(resList.size() - 1);
            if (tempArr[1] >= intervals[i][0]) { // merge
                int min = Math.min(tempArr[0], intervals[i][0]);
                int max = Math.max(tempArr[1], intervals[i][1]);
                resList.remove(tempArr);
                resList.add(new int[] { min, max });
            } else {
                resList.add(intervals[i]);
            }
        }
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
