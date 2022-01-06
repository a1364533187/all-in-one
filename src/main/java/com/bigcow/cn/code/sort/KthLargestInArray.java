package com.bigcow.cn.code.sort;

public class KthLargestInArray {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    public int findKthLargest(int[] nums, int k, int left, int right) {
        int mid = partition(nums, left, right);
        if (mid == nums.length - k) {
            return nums[mid];
        } else if (mid > nums.length - k) {
            return findKthLargest(nums, k, left, mid - 1);
        } else {
            return findKthLargest(nums, k, mid + 1, right);
        }
    }

    /**
     * 大的在pivot 右边， 小的在pivot 左边
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }

        nums[left] = pivot;
        return left;
    }
}
