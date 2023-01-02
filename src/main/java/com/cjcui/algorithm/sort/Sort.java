package com.cjcui.algorithm.sort;

public class Sort {
    //冒泡 稳定
    public void sort1(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                int temp = arr[j];
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    //选择 不稳定

    public void sort2(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //插入 稳定
    public void sort3(int[] arr) {
        int length = arr.length;
        for (int i = 1, j; i < length; i++) {
            int curr = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > curr; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = curr;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //归并

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 7, 9, 4, 3};
        Sort sort = new Sort();
//        sort.sort1(arr);
//        sort.sort2(arr);
        sort.sort3(arr);
    }
}
