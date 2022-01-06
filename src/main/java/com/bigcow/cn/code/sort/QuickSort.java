package com.bigcow.cn.code.sort;

public class QuickSort {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[] nums = { 5, 7, 9, 0, 1, 2, 3 };
        quickSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print("--->" + nums[i]);
        }
    }

    //"分柚子" 分区-右移-左移
    private static int partition(int[] nums, int left ,int right){

        // 经典快速排序的写法
        // 设置当前区间的第一个元素为基准元素
        int pivot = nums[left];

        // left 向右移动，right 向左移动，直到 left 和 right 指向同一元素为止
        while( left < right ){

            // 只有当遇到小于 pivot 的元素时，right 才停止移动
            // 此时，right 指向了一个小于 pivot 的元素，这个元素不在它该在的位置上
            while( left < right && nums[right] >= pivot ){
                // 如果 right 指向的元素是大于 pivot 的，那么
                // right 不断的向左移动
                right--;
            }
            // 将此时的 nums[left] 赋值为 nums[right]
            // 执行完这个操作，比 pivot 小的这个元素被移动到了左侧
            nums[left] = nums[right];


            // 只有当遇到大于 pivot left 才停止移动
            // 此时，left 指向了一个大于 pivot 的元素，这个元素不在它该在的位置上
            while( left < right && nums[left] <= pivot){
                // 如果 left 指向的元素是小于 pivot 的，那么
                // left 不断的向右移动
                left++;
            }

            // 将此时的 nums[right] 赋值为 nums[left]
            // 执行完这个操作，比 pivot 大的这个元素被移动到了右侧
            nums[right] = nums[left];

        }
        // 此时，left 和 right 相遇，那么需要将此时的元素设置为 pivot
        // 这个时候，pivot 的左侧元素都小于它，右侧元素都大于它
        nums[left] = pivot;

        // 返回 left
        return left;

    }

    public static void quickSort(int[] nums) {
        if (nums.length <= 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(nums, left, right);
        quickSort(nums, 0, mid - 1);
        quickSort(nums, mid + 1, right);
    }

}
