package com.cjcui.algorithm;

/**
 * 插入排序
 *
 * @author cjcui
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {6, 4, 1, 3, 7, 4, 9};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        int x = 10;
        int y = 0;
        y = x++;
        System.out.println("x=" + x);
        System.out.println("y=" + y);
    }

    public static void sort(int[] a) {
        int left = 0;
        int right = a.length - 1;
        for (int i = left, j = i; i < right; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == left) {
                    break;
                }
            }
            a[j + 1] = ai;
        }

    }
}
