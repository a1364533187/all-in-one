package com.bigcow.cn.code.shopee.dp.package01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GreatestSumDivisibleByThree1262 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 4 };
        System.out.println(maxSumDivThree(nums));
    }

    /**
     * 贪婪法
     * 我们将所有的数字加起来，我们不妨设为 total
     * total 除以 3，得到一个余数 mod， mod 可能值有 0，1，2.
     * 同时我们建立两个数组，一个是余数为 1 的数组 one，一个是余数为 2 的数组 two
     * 如果 mod 为 0，我们直接返回即可。
     * 如果 mod 为 1，我们可以减去 one 数组中最小的一个（如果有的话），或者减去两个 two 数组中最小的（如果有的话），究竟减去谁取决谁更小。
     * 如果 mod 为 2，我们可以减去 two 数组中最小的一个（如果有的话），或者减去两个 one 数组中最小的（如果有的话），究竟减去谁取决谁更小。
     * https://lucifer.ren/leetcode/problems/1262.greatest-sum-divisible-by-three.html
     * @param nums
     * @return
     */
    public static int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] % 3 == 1) {
                one.add(nums[i]);
            }
            if (nums[i] % 3 == 2) {
                two.add(nums[i]);
            }
        }
        if (sum % 3 == 0) {
            return sum;
        }
        List<Integer> oneSorted = one.stream().sorted().collect(Collectors.toList());
        List<Integer> twoSorted = two.stream().sorted().collect(Collectors.toList());

        if (sum % 3 == 1) {
            int sub = Math.min(oneSorted.isEmpty() ? Integer.MAX_VALUE : oneSorted.get(0),
                    twoSorted.size() < 2 ? Integer.MAX_VALUE : twoSorted.get(0) + twoSorted.get(1));
            sub = sub == Integer.MAX_VALUE ? 0 : sub;
            return sum - sub;
        } else {
            int sub = Math.min(twoSorted.isEmpty() ? Integer.MAX_VALUE : twoSorted.get(0),
                    oneSorted.size() < 2 ? Integer.MAX_VALUE : oneSorted.get(0) + oneSorted.get(1));
            sub = sub == Integer.MAX_VALUE ? 0 : sub;
            return sum - sub;
        }

    }
}
