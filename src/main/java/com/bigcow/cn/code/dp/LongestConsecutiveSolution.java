package com.bigcow.cn.code.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutiveSolution {

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }

    //具体过程如下：
    //1、定义一个哈希表hash，将nums数组中的数都放入哈希表中。
    //2、遍历哈希表hash，如果当前数x的前驱x-1不存在，我们就以当前数x为起点向后枚举。
    //3、假设最长枚举到了数y，那么连续序列长度即为y-x+1。
    //4、不断枚举更新答案。
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (!set.contains(x - 1)) { // 作为起点向后枚举
                while (set.contains(x++));
                max = Math.max(max, x - nums[i] - 1);
            }
        }
        return max;
    }
}
