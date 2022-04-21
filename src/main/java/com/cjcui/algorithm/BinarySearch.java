package com.cjcui.algorithm;

public class BinarySearch {
    //基本二分搜索
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    //寻找左侧边界的二分搜索
    public int binarySearch2(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                right = mid;
            } else if (arr[mid] > target) {
                left = mid + 1;
            } else if (arr[mid] < target) {
                right = mid;
            }
        }
        return left;
    }
}
