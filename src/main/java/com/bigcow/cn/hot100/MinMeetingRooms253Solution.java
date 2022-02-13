package com.bigcow.cn.hot100;

import java.util.Arrays;

public class MinMeetingRooms253Solution {

    public static void main(String[] args) {
        //        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 }, {40, 70} };

                int[][] intervals = {{2,11},{6,16},{11,16}};
                //        int[][] intervals = { { 9, 16 }, { 6, 16 }, { 1, 9 }, { 3, 15 } };
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int end = 0;
        int roomCnt = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[end]) {
                System.out.println("---" + starts[i]);
                roomCnt++;
            } else {
                end++;
            }
        }
        return roomCnt;
    }
}
