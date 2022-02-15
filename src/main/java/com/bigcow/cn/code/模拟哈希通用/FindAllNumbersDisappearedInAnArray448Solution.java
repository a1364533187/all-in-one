package com.bigcow.cn.code.模拟哈希通用;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray448Solution {

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDisappearedNumbers(nums));
    }

    /**
     * 置换大法好
     * 1、能映射的映射方案： 1 映射到0的位置， 2 映射到1的位置等等， 当nums[i] == nums[nums[i] -1] 时，会无限置换，跳过即好
     * 2、不能映射的留在原位置，等待其他元素的置换
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length) { // 开启swap
                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        //遍历数组，元素不在对应位置上的，就是缺失的元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        // 都在对应的位置上了， 缺失的就是n+1的元素了
        return list;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
