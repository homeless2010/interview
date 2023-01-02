package com.cjcui.practice.od;

public class BinarySearch {
    /**
     * 递归
     *
     * @param arr
     * @param low
     * @param high
     * @param key
     * @return
     */
    int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high) {
            return -1;
        }
        int mid = (high + low) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            high = mid - 1;
            return binarySearch(arr, low, high, key);
        } else {
            low = mid + 1;
            return binarySearch(arr, low, high, key);
        }
    }

    /**
     * 非递归
     */
    int binarySearch(int[] arr, int key) {
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight) {
            int mid = (hight + low) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else if (key < arr[mid]) {
                hight = mid - 1;
            }
        }
        return -1;
    }

}
