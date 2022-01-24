package com.bigcow.cn.code.other.shuffle;

public class ShuffleSolution {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        ArrayShuffle384Solution arrayShuffle384Solution = new ArrayShuffle384Solution(nums);
        arrayShuffle384Solution.shuffle();
        for (int i = 0; i < nums.length; i++) {
            System.out.print("---" + nums[i]);
        }
        arrayShuffle384Solution.shuffle();
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print("---" + nums[i]);
        }
        System.out.println();
        int[] resets = arrayShuffle384Solution.reset();
        for (int i = 0; i < resets.length; i++) {
            System.out.print("---" + resets[i]);
        }
        System.out.println();
    }
}
