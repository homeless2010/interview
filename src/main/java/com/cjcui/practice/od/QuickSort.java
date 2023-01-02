package com.cjcui.practice.od;

public class QuickSort {
    int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
        return arr;
    }

    int[] quickSort5(int[] arr, int left, int right) {
        if (left < right) {
            int i = partition4(arr, left, right);
            quickSort5(arr, left, i - 1);
            quickSort5(arr, i + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        //设定基准值(pivot)
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i < right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    int[] quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition2(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
        return arr;
    }

    private int partition2(int[] arr, int left, int right) {
        //设定基准值
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i < right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void swap2(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private void swap4(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition4(int[] arr, int left, int right) {
        int pivot = left;
        int index = left + 1;
        for (int i = index; i < right; i++) {
            if (arr[pivot] > arr[i]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }
}
