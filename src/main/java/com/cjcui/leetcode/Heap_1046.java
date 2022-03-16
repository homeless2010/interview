package com.cjcui.leetcode;

import java.util.PriorityQueue;

public class Heap_1046 {
    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 1, 8, 1};
        new Heap_1046().lastStoneWeight(arr);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
