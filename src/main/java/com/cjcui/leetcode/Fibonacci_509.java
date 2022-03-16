package com.cjcui.leetcode;

public class Fibonacci_509 {
    public static void main(String[] args) {
        int r = new Fibonacci_509().fib2(5);
        System.out.println(r);
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public int fib2(int n) {
        if (n < 2) {
            return n;
        } else {
            int q = 0, p, r = 0;
            for (int i = 2; i < n + 2; i++) {
                if (i == 2) {
                    q = 0;
                    p = 1;
                    r = q + p;
                } else {
                    int temp = q;
                    q = r;
                    p = temp;
                    r = q + p;
                }
            }
            return r;
        }
    }
}
