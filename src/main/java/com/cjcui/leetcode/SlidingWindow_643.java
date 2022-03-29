package com.cjcui.leetcode;

/**
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 */
public class SlidingWindow_643 {
    //暴力超时
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        double average = 0;
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            int sum = 0;
            for (int l = i; l <= j; l++) {
                sum += nums[l];
            }
            if (i == 0) {
                average = sum / (k / 1d);
            } else {
                average = Math.max(average, 1.0 * sum / k);
            }
        }
        return average;
    }

    //
    public double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}
