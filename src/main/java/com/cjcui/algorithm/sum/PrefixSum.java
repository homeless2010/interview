package com.cjcui.algorithm.sum;

import java.util.HashMap;

/**
 * 前缀和
 */
public class PrefixSum {
    int subArraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        sums[0] = 0;
        for (int i = 0; i < n; i++) {
            sums[i + 1] = nums[i] + sums[i];
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (sums[i] - sums[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //哈希表优化
    int subArraySum2(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> table = new HashMap<>();
        table.put(0, 1);
        int count = 0, sums = 0;
        for (int i = 0; i < n; i++) {
            sums += nums[i];
            int reduce = sums - k;
            if (table.containsKey(reduce)) {
                count += table.get(reduce);
            }
            table.put(sums, table.getOrDefault(sums, 0) + 1);
        }
        return count;
    }
}
