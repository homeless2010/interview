package com.cjcui.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberSum {
    public static void main(String[] args) {
        int[] sss = new int[]{-3, 4, 3, 90};
        new NumberSum().twoSum(sss, 0);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> hasMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hasMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer integer = hasMap.get(target - nums[i]);
            if (integer != null && !integer.equals(i)) {
                ret[0] = i;
                ret[1] = integer;
                return ret;
            }
        }
        return ret;
    }
}
