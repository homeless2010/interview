package com.cjcui.algorithm;

import java.util.Arrays;

/**
 * @author cjcui
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {3, 2, 4, 1, 1, 5, 1, 3, 5, 1};
        minPairSum(array);
    }

    public static int minPairSum(int[] nums) {
/*        for (int i = 0; i < nums.length -1; i++) {
            for (int j = 0; j < nums.length -i - 1; j++) {
                int temp = nums[j];
                if (nums[j] > nums[j + 1]) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }*/
        int[] numsSort = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (temp > nums[j]) {
                    temp = nums[j];
                    index = j;
                }
            }
            nums[index] = nums[i];
            nums[i] = temp;
        }
        int max = 0;
        for (int i = 0; i < (nums.length / 2); i++) {
            int sum1 = nums[i] + nums[nums.length - i - 1];
            if (max > sum1) {

            } else {
                max = sum1;
            }
        }
        Arrays.sort(nums);
        System.out.println(max);
        return 0;
    }

}