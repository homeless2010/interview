package com.cjcui.leetcode;

/**
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 */
public class Array_17_16 {
    public int massage(int[] nums) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                sum2 += nums[i];
            } else {
                sum1 += nums[i];
            }
        }
        return Math.max(sum1, sum2);
    }
}
