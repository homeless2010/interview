package com.cjcui.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 973. 最接近原点的 K 个点
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class L973 {
    Random random = new Random();

    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingDouble(arr -> Math.pow(arr[0], 2) + Math.pow(arr[1], 2)));
        return Arrays.copyOfRange(points, 0, k);
    }

    /**
     * 大顶堆
     *
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] + o1[1] * o1[1]);
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        for (int i = k; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < priorityQueue.peek()[0]) {
                priorityQueue.poll();
                priorityQueue.offer(new int[]{dist, i});
            }
        }
        int[][] ret = new int[k][2];
        for (int i = 0; i < k; i++) {
            ret[i] = points[priorityQueue.poll()[1]];
        }
        return ret;
    }

    /**
     * 快排
     *
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest3(int[][] points, int k) {
        randomSelect(points, 0, points.length, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    public void randomSelect(int[][] points, int left, int right, int k) {
        int pivotId = left + random.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (pivot < dist) {
                swap(points, i, j);
                i++;
            }
        }
        i++;
        swap(points, i, right);
        if (k < i - left + 1) {
            randomSelect(points, left, i - 1, k);
        } else if (k > i - left + 1) {
            randomSelect(points, i + 1, right, k - (i - left + 1));
        }
    }

    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}