package com.cjcui.algorithm;

public class Fibonacci1 {
    public static void main(String[] args) {
        System.out.println(new Fibonacci1().fibonacci(3));
        System.out.println(new Fibonacci1().fibonacci(4));
        System.out.println(new Fibonacci1().fibonacci(5));
        System.out.println(new Fibonacci1().fibonacci2(3));
        System.out.println(new Fibonacci1().fibonacci2(4));
        System.out.println(new Fibonacci1().fibonacci2(5));
    }

    int fibonacci(int i) {
        if (i == 0) {
            return 0;
        }
        if ((i == 1) || (i == 2)) {
            return 1;
        }
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    int fibonacci2(int i) {
        if (i == 0) {
            return 0;
        }
        int[] arr = new int[i + 1];
        return helper(arr, i);
    }

    int helper(int[] arr, int i) {
        if ((i == 1) || (i == 2)) {
            return 1;
        }
        if (arr[i] != 0) {
            return arr[i];
        }
        arr[i] = helper(arr, i - 1) + helper(arr, i - 2);
        return arr[i];
    }
}