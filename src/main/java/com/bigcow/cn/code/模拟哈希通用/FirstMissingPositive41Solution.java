package com.bigcow.cn.code.模拟哈希通用;

public class FirstMissingPositive41Solution {

    public static void main(String[] args) {
        int[] nums = { 7,8,9,11,12 };
        System.out.println(firstMissingPositive(nums));
    }

    /**
     * 采用官方的方法二 置换：
     * https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
     * 1、能映射的映射方案： 1 映射到0的位置， 2 映射到1的位置等等， 当nums[i] == nums[nums[i] -1] 时，会无限置换，跳过即好
     * 2、不能映射的留在原位置，等待其他元素的置换
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length) { // 开启swap
                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        //遍历数组，元素不在对应位置上的，就是缺失的元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都在对应的位置上了， 缺失的就是n+1的元素了
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
