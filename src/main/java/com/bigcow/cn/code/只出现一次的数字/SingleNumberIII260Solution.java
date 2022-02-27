package com.bigcow.cn.code.只出现一次的数字;

public class SingleNumberIII260Solution {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        System.out.println(singleNumber(nums));

        System.out.println(6 & (-6));
        /**
         * 6 
         * 二进制表示     0000 0000 0000 0110
         * 
         *         -6 负数通过补码表示
         *         原码  1000 0000 0000 0110
         *
         *         反码  1111 1111 1111 1001
         *
         *         补码  1111 1111 1111 1010
         */

    }

    public static int[] singleNumber(int[] nums) {
        int xorRes = 0;
        for (int i = 0; i < nums.length; i++) {
            xorRes ^= nums[i];
        }
        // 通过异或找到低位首次出现1的位置
        int lowbit = xorRes & (-xorRes);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((lowbit & nums[i]) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }

}
