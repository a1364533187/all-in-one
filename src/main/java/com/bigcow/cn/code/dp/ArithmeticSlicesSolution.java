package com.bigcow.cn.code.dp;

public class ArithmeticSlicesSolution {

    /**
     * 1,2,3,4,5
     *
     * 截止到3: 1，2，3
     * 截止到4: 2，3，4/1，2，3，4 ---- 上一轮的每次结果移除一位，加上4， 结果个数为dp[i-1], 不移除，加5全集+ 1， 也就是dp[i-1] +1
     * 截止到5: 3，4，5/2，3，4，5/1，2，3，4，5 ---- 上一轮的每次结果移除一位，加上5， 结果个数为dp[i-1], 不移除，加5全集+ 1， 也就是dp[i-1] +1
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
