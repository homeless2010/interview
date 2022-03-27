package com.cjcui.leetcode;
/**
 * https://leetcode-cn.com/problems/jBjn9C/
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class KthLargest {
    private Set<Integer> nums;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            this.nums.add(nums[i]);
        }
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        int add = kthLargest.add(3);
    }

    public int add(int val) {
        nums.add(val);
        Iterator<Integer> iterator = nums.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            if (i == (nums.size() - k)) {
                return iterator.next();
            }
            i++;
        }
        return 0;
    }
}
