package com.cjcui.algorithm;

/**
 * 斐波那契
 */
public class Fibonacci {
    //暴力递归
    public int sum(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return sum(n - 1) + sum(n - 2);
    }

    //动态规划
    public static void main(String[] args) {
        System.out.println(new Fibonacci().sum(3));
        System.out.println(new Fibonacci().sum(5));
        System.out.println("**************************");
        System.out.println(new Fibonacci().sum2(3));
        System.out.println(new Fibonacci().sum2(5));
    }

    public int sum2(int num) {
        if (num == 0) {
            return 0;
        }
        int[] arr = new int[num + 1];
        return helper(arr, num);
    }

    int helper(int[] arr, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = helper(arr, n - 1) + helper(arr, n - 2);
        return arr[n];
    }
}
