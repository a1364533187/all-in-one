package com.bigcow.cn.hot100;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers448Solution {

    public static void main(String[] args) {
        //        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        int[] nums = { 1, 1 };
        System.out.println(findDisappearedNumbers(nums));
    }

    /**
     * 新型的HASH,自实现
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        //第一遍： 给每个元素对应的（索引位置）加上数组的长度,
        // 遍历过程索引位置的确认，可能已经加上过数组的长度了，所以需要求mod, 还原原来的索引位置
        // 遍历的位置>数组的长度的话，则对数组长度求余
        for (int i = 0; i < nums.length; i++) {
            //
            int index = (nums[i] - 1) % nums.length;
            nums[index] = nums[index] + nums.length;
        }

        List<Integer> arr = new ArrayList<>();
        // 第二遍, 找到没有加过数组长度的位置，既是缺失的元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                arr.add(i + 1);
            }
        }
        return arr;
    }
}
