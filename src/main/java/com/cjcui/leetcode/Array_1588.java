package com.cjcui.leetcode;

public class Array_1588 {
    public static void main(String[] args) {
        int i = new Array_1588().sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3});
        System.out.println(i);
    }

    //暴力
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length; i++) {
            if ((i & 1) == 1) {
                int j = 0;
                while (j <= arr.length - i) {
                    for (int k = j; k < j + i; k++) {
                        sum += arr[k];
                    }
                    j++;
                }
            }
        }
        return sum;
    }

    //前缀和
    public int sumOddLengthSubarrays2(int[] arr) {
        int[] prefixArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixArr[i + 1] = prefixArr[i] + arr[i];
        }
        int sum = 0;
        for (int start = 0; start < arr.length; start++) {
            for (int length = 1; start + length <= arr.length; length += 2) {
                int end = start + length + 1;
                sum += prefixArr[end + 1] - prefixArr[start];
            }
        }
        return sum;
    }

    //数学
    public int sumOddLengthSubarrays3(int[] arr) {
        return 0;
    }
}
