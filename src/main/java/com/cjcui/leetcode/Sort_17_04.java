package com.cjcui.leetcode;

import java.util.PriorityQueue;

public class Sort_17_04 {
    public static void main(String[] args) {
        int i = new Sort_17_04().missingNumber(new int[]{3, 0, 1});
        System.out.println(i);
    }

    public int missingNumber(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
        }
        int pre = 0;
        Integer poll = 0;
        int first = 0;
        for (int i = 0; i < nums.length; i++) {
            poll = priorityQueue.poll();
            if (i == 0) {
                first = poll;
            } else {
                if ((poll - pre) > 1) {
                    return pre + 1;
                }
            }
            pre = poll;
        }
        return first == 0 ? poll + 1 : 0;
    }

    public int missingNumber2(int[] nums) {
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target ^= i;
            target ^= nums[i];
        }
        target ^= nums.length;
        return target;
    }
}
