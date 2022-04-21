package com.cjcui.algorithm;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 2, 8, 9, 4, 7, 10};
        int[] ints = new QuickSort().quickSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] quickSort(int[] arr) {
        return sort(arr, 0, arr.length - 1);
    }


    public int[] sort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            sort(arr, left, partition - 1);
            sort(arr, partition + 1, right);
        }
        return arr;
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    public void swap(int[] arr, int i, int j) {
        int n = arr[i];
        arr[i] = arr[j];
        arr[j] = n;
    }
}
