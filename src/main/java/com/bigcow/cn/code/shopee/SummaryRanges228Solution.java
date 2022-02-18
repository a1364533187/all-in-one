package com.bigcow.cn.code.shopee;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228Solution {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 4, 5, 7 };
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length <= 0) {
            return new ArrayList<>();
        }
        int start = 0;
        int end = 1;
        List<String> res = new ArrayList<>();
        while (end < nums.length) {
            while (end < nums.length && nums[end] == nums[end - 1] + 1) {
                end++;
            }
            if (end - start == 1) {
                res.add("" + nums[start]);
            } else {
                res.add(nums[start] + "->" + nums[end - 1]);
            }
            start = end;
            end = end + 1;
        }
        if (start < nums.length && end - start == 1) {
            res.add("" + nums[start]);
        }
        return res;
    }
}
