package com.bigcow.cn.code.tencent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInAnArray442Solution {

    public static void main(String[] args) {
        int[] nums = { 5, 4, 6, 7, 9, 3, 10, 9, 5, 6 };
        System.out.println(findDuplicates(nums));
        System.out.println();
    }

    public static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                if (nums[i] - 1 != i) {
                    swap(nums, nums[i] - 1, i);
                }
            }
            if (nums[i] - 1 != i) {
                res.add(nums[i]);
            }
        }
        return new ArrayList<>(res);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
