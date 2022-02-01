package com.bigcow.cn.hot100;

public class FindDuplicate287Solution {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println("---" + findDuplicate(nums));
    }

    /**
     * 1、把数组的值看成 next 指针，
     * 2、数组的下标看成节点的索引。
     * 因为数组中至少有两个值一样，也说明有两个节点指向同一个位置，所以一定会出现环。
     *
     * 典型的找环的起点的问题
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
