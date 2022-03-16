package com.cjcui.leetcode;

public class MoveZero_283 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        new MoveZero_283().moveZeroes2(nums);

//        a + mul = res;
//        res - mul + mul * val
    }

    public void moveZeroes(int[] nums) {
        int right;
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            int j = i;
            while (nums[j] == 0 && j < length - 1) {
                j++;
            }
            if (nums[i] == 0) {
                count++;
                right = i;
                while (right < length - (j - i)) {
                    nums[right] = nums[right + j - i];
                    ++right;
                }
                nums[length - count] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void moveZeroes1(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        while (right < length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }


    void moveZeroes2(int[] nums) {
        int length = nums.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < length; i++) {
            nums[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
