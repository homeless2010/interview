package com.cjcui.leetcode;

import java.util.concurrent.ForkJoinPool;

public class Sort_61 {
    public static void main(String[] args) {
        boolean straight = new Sort_61().isStraight(new int[]{0, 0, 2, 2, 5});
        System.out.println(straight);
    }

    public boolean isStraight(int[] nums) {
        int value0 = 0;
        int target = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] == 0) {
//                ForkJoinPool
                value0++;
            } else {
                target ^= Math.abs(nums[i - 1] - nums.length + 1);
            }
            target ^= i;
        }
        if (value0 == 0) {
            return target == 0;
        } else if (value0 == 1) {
            return target <= 4;
        } else {
            for (int i = 1; i <= 5; i++) {
                for (int j = i + 1; j <= 5; j++) {
                    target ^= i;
                    target ^= j;
                    if (target == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
