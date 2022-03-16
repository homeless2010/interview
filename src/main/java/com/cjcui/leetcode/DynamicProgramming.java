package com.cjcui.leetcode;

/**
 * 动态规划
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        System.out.println(new DynamicProgramming().fib(4));
        ;
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
