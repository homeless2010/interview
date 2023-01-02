package com.cjcui.practice.od;

public class Tessssss {
    public int removeDuplicates(int[] nums) {
        int num = 0;
        int ffff = 0;
        for (int j = 0; j < nums.length - 1 - ffff; j++) {
            int ddd = 0;
            for (int k = j + 1; k < nums.length - ffff; k++) {
                if (nums[j] == nums[k]) {
                    ddd++;
                }
            }
            if (ddd > 0) {
                for (int i = j + 1; i < nums.length - ddd; i++) {
                    nums[i] = nums[i + ddd];
                }
                ffff += ddd;
                num++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return nums.length - ffff;
    }

    public int removeDuplicates2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        int i = new Tessssss().removeDuplicates(a);
        int j = new Tessssss().removeDuplicates2(a);
        System.out.println();
        System.out.println(i);
        System.out.println(j);
    }
}
