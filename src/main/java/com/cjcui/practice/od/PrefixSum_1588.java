package com.cjcui.practice.od;

/**
 * 前缀和
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 */
public class PrefixSum_1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j + i < arr.length; j += 2) {
                sum += prefixSum[i + j] - prefixSum[i];
            }
        }
        return sum;
    }
}
