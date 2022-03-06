package com.bigcow.cn.code.tencent;

import java.util.Random;

public class RandomPickWithWeight528Solution {

    public static void main(String[] args) {
//        Random r = new Random();
//        for (int i = 0; i < 10; i++) {
//            int val = r.nextInt(2);
//            System.out.print(val);
//        }
        int[] nums = {1,3};
        RandomPickWithWeight528Solution solution = new RandomPickWithWeight528Solution(nums);
        System.out.println(solution.pickIndex()); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
        System.out.println(solution.pickIndex()); // 返回 1
        System.out.println(solution.pickIndex()); // 返回 1
        System.out.println(solution.pickIndex()); // 返回 1
        System.out.println(solution.pickIndex()); // 返回 0，返回下标 0，返回该下标概率为 1/4
    }

    int[] preSums;
    int total;

    public RandomPickWithWeight528Solution(int[] w) {
        total = 0;
        preSums = new int[w.length];
        preSums[0] = w[0];
        total += w[0];
        for (int i = 1; i < w.length; i++) {
            preSums[i] = preSums[i - 1] + w[i];
            total += w[i];
        }
    }

    public int pickIndex() {
        Random r = new Random();
        int val = r.nextInt(total) + 1; // [0, total)
        return upperBound(preSums, val);
    }

    // 从前缀和数组, 比如w = [2,3,1], presum = [2,5,6], 随机数[1, 6]
    public int upperBound(int[] preSums, int val) {
        int start = 0;
        int end = preSums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (preSums[mid] < val) {
                start = mid + 1;
            } else if (preSums[mid] == val) {
                return mid;
            } else { // preSums[mid] > val
                end = mid;
            }
        }
        return start;
    }
}
