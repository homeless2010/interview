package practice.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Queue_2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = i;
            arr[i][0] = nums[i];
        }
        Arrays.sort(arr, (x, y) -> y[1] - x[1]);
        Arrays.sort(arr, Comparator.comparingInt(x -> x[0]));
        int[] ret = new int[k];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = arr[i][1];
        }
        return ret;
    }
}
