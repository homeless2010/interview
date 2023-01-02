package com.cjcui.practice;

import java.util.*;

public class SkiRankingSystem {
    List<int[]> allRecord;
    Map<Integer, PriorityQueue<Integer>> record;

    public SkiRankingSystem() {
        this.allRecord = new ArrayList<>();
        this.record = new HashMap<>();
    }

    public void addRecord(int userId, int duration) {
        PriorityQueue<Integer> queue = this.record.get(userId);
        if (queue == null) {
            queue = new PriorityQueue<>();
        }
        queue.offer(duration);
        this.record.put(userId, queue);
        int[] record2 = new int[2];
        record2[0] = userId;
        record2[1] = duration;
        allRecord.add(record2);
    }

    public int[] getTopAthletes(int num) {
        List<Integer> list = new ArrayList<>();
        int[][] arr = new int[this.record.size()][2];
        Set<Integer> durations = new HashSet<>();
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : this.record.entrySet()) {
            arr[i][0] = entry.getKey();
            Integer poll = entry.getValue().peek();
            arr[i][1] = poll;
            durations.add(poll);
            i++;
        }
        Iterator<Integer> iterator = durations.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            if (count == num) {
                break;
            }
            Integer next = iterator.next();
            for (int k = 0; k < arr.length; k++) {
                if (next == arr[k][1]) {
                    list.add(arr[k][0]);
                    count++;
                    break;
                }
            }
        }
        int[] ret = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ret[k] = list.get(k);
        }
        return ret;
    }

    public int[] queryTop3Record(int userId) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> integers = this.record.get(userId);
        if (integers == null) {
            return new int[0];
        }
        int i = 0;
        while (integers.peek() != null) {
            Integer poll = integers.peek();
            list.add(poll);
        }
        int[] ret = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            ret[i] = list.get(j);
        }
        return ret;
    }

    public static void main(String[] args) {
        SkiRankingSystem skiRankingSystem = new SkiRankingSystem();
        skiRankingSystem.addRecord(1, 10);
        skiRankingSystem.addRecord(2, 8);
//        skiRankingSystem.addRecord(20, 8);
//        skiRankingSystem.addRecord(22, 6);
//        skiRankingSystem.addRecord(20, 6);
        int[] topAthletes = skiRankingSystem.getTopAthletes(4);
        int[] topAthletes2 = skiRankingSystem.queryTop3Record(1);
    }
}
