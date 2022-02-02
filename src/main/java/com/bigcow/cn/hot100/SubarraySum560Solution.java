package com.bigcow.cn.hot100;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum560Solution {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        System.out.println(subarraySum(nums, 2));
    }

    // 计算前缀和, 时间复杂度O(N*N), 空间复杂度 O(N)
    // https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
    //    public static int subarraySum(int[] nums, int k) {
    //        int len = nums.length;
    //        int[] prefixSum = new int[len + 1];
    //        prefixSum[0] = 0;
    //        for (int i = 0; i < len; i++) {
    //            prefixSum[i + 1] = prefixSum[i] + nums[i];
    //        }
    //
    //        int count = 0;
    //        for (int i = 0; i < len; i++) {
    //            for (int j = i; j < len; j++) {
    //                if (prefixSum[j + 1] - prefixSum[i] == k) {
    //                    count++;
    //                }
    //            }
    //        }
    //
    //        return count;
    //    }

    // 计算前缀和 + HashMAP, 时间复杂度O(N), 空间复杂度 O(N)
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int preSum = 0;
        // 统计的是preSum 和对应出现的频次
        Map<Integer, Integer> preSumFreqMap = new HashMap<>();
        preSumFreqMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum+=nums[i];
            if (preSumFreqMap.containsKey(preSum - k)) {
                count += preSumFreqMap.get(preSum - k);
            }
            preSumFreqMap.put(preSum, preSumFreqMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
