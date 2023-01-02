package com.cjcui.practice;

import java.util.*;

public class SkiRankingSystem3 {
    //key 成绩 list userId 某个成绩的user
    Map<Integer, List<Integer>> m1 = new TreeMap<>();
    //key userId list成绩 单个用户成绩
    Map<Integer, List<Integer>> m2 = new HashMap<>();

    public void addRecord(int userId, int duration) {
        List<Integer> list = m1.get(duration);
        if (list == null) {
            list = new ArrayList<>();
            list.add(userId);
            m1.put(duration, list);
        } else {
            list.add(userId);
        }
        List<Integer> list1 = m2.get(userId);
        if (list1 == null) {
            list1 = new ArrayList<>();
            list1.add(duration);
            m2.put(userId, list1);
        } else {
            list1.add(duration);
        }
    }

    public int[] queryTop3Record(int userId) {
        List<Integer> list = m2.get(userId);
        list.sort(Comparator.comparingInt(Integer::intValue));
        int length = list.size() < 3 ? list.size() : 3;
        int[] ret = new int[length];
        for (int i = 0; i < length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
