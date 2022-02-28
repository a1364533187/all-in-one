package com.bigcow.cn.code.tree.子集;

import java.util.Arrays;

public class CanPartitionKSubsets698Solution {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9 };
        System.out.println(canPartitionKSubsets(nums, 5));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        if (max > target) {
            return false;
        }
        Arrays.sort(nums);
        reverse(nums, 0, nums.length - 1);
        int[] buckets = new int[k];
        return DFS(nums, target, k, 0, buckets);
    }

    // 数组反转
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static boolean DFS(int[] nums, int target, int k, int index, int[] buckets) {
        if (index == nums.length) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            // 加上这个效率就干上去了
            if (buckets[i] + nums[index] > target || (i > 0 && buckets[i] == buckets[i - 1])) {
                continue;
            }
            buckets[i] += nums[index];
            if (DFS(nums, target, k, index + 1, buckets)) {
                return true;
            }
            buckets[i] -= nums[index];
        }
        return false;
    }

    //    public static boolean canPartitionKSubsets(int[] nums, int k) {
    //        int sum = 0;
    //        for (int i = 0; i < nums.length; i++) {
    //            sum += nums[i];
    //        }
    //        if (sum % k != 0) {
    //            return false;
    //        }
    //
    //        int target = sum / k;
    //        boolean[] visitied = new boolean[nums.length];
    //        List<List<Integer>> res = new ArrayList<>();
    //        DFS(nums, target, visitied, new LinkedList<>(), res, 0);
    //        return res.size() == k;
    //    }
    //
    //    // 数组反转
    //    private static void reverse(int[] nums) {
    //        for (int i = 0; i < nums.length / 2; i++) {
    //            int temp = nums[i];
    //            nums[i] = nums[nums.length - 1 - i];
    //            nums[nums.length - 1 - i] = temp;
    //        }
    //    }
    //
    //    public static void DFS(int[] nums, int target, boolean[] visited, LinkedList<Integer> path,
    //            List<List<Integer>> res, int begin) {
    //        if (target == 0) {
    //            for (int i = 0; i < path.size(); i++) {
    //                if (visited[path.get(i)]) {
    //                    return;
    //                }
    //            }
    //            res.add(new ArrayList<>(path));
    //            for (int i = 0; i < path.size(); i++) {
    //                visited[path.get(i)] = true;
    //            }
    //            return;
    //        }
    //        for (int i = begin; i < nums.length; i++) {
    //            if (visited[i] || nums[i] > target) {
    //                continue;
    //            }
    //            path.add(i);
    //            DFS(nums, target - nums[i], visited, path, res, i + 1);
    //            path.removeLast();
    //        }
    //    }
}
