package com.cjcui.practice.od;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/kLl5u1/
 */
public class DoublePointer_006 {
    //暴力 超时
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        label:
        for (int i = 0; i < numbers.length; i++) {
            int j = i + 1;
            while (j < numbers.length) {
                if (numbers[i] + numbers[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    break label;
                }
                j++;
            }
        }
        return ret;
    }

    //hash表
    public int[] twoSum2(int[] numbers, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target - numbers[i]) != null) {
                ret[0] = i;
                ret[1] = map.get(target - numbers[i]);
                break;
            }
        }
        return ret;
    }

    //双指针
    public int[] twoSum3(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] ints = new DoublePointer_006().twoSum(new int[]{1, 2, 4, 6, 10}, 8);
    }
}
