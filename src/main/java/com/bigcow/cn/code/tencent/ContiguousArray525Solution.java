package com.bigcow.cn.code.tencent;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray525Solution {

    /**
     * https://leetcode-cn.com/problems/contiguous-array/solution/lian-xu-shu-zu-by-leetcode-solution-mvnm/
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1 };
//        int[] nums = { 0, 0, 1, 0, 0, 0, 1, 1 };
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int presum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += getCur(nums[i]);
            if (map.containsKey(presum)) {
                res = Math.max(res, i - map.get(presum));
            }
            // 存和为presum 的最小索引
            map.put(presum, map.getOrDefault(presum, i));
        }
        return res;
    }

    private static int getCur(int val) {
        return val == 0 ? -1 : 1;
    }
}
