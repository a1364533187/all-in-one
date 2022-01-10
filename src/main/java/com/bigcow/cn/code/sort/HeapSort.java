package com.bigcow.cn.code.sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = { 5, 1, 1, 2, 0, 0 };
        heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    // 从小到大排
    public static void heapSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        // 首先构建好大顶堆, 找到第一个非叶子节点
        for (int i = (nums.length >> 2 - 1); i >= 0; i--) {
            heapShift(nums, i, nums.length - 1);
        }
        // 不断调整，不断交换最大值放到最后面
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapShift(nums, 0, i - 1);
        }
    }

    private static void heapShift(int[] nums, int dad, int end) {
        while (dad <= end) {
            int son = 2 * dad + 1;
            //找到2个son 的最大值
            if (son + 1 <= end && nums[son + 1] > nums[son]) {
                son = son + 1;
            }
            // 比较dad 和 son
            if (son <= end && nums[dad] < nums[son]) {
                swap(nums, dad, son);
                dad = son;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
