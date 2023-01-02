package com.cjcui.practice;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution3 {
    public int getMaxDepth(String inputStr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == '(' || inputStr.charAt(i) == ')') {
                sb.append(inputStr.charAt(i));
            }
        }
        String s = sb.toString();
        int count = 0;
        while (s.length() != 0) {
            s = s.replaceAll("\\(\\)", "");
            count++;
        }
        return count;
    }

    public static int[] getClosestPositions(int[][] positions, int num) {
        TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<>();

        for (int i = 0; i < positions.length; i++) {
            int sum = positions[i][0] * positions[i][0] + positions[i][1] * positions[i][1];
            if (hm.get(sum) == null) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                hm.put(sum, al);
            } else {
                hm.get(sum).add(i);
            }
        }
        TreeSet<Integer> ts = new TreeSet<>();
        int count = 0;
        for (Integer now : hm.keySet()) {
            ArrayList<Integer> ali = hm.get(now);
            if (count >= num) {
                break;
            }
            for (int i = 0; i < ali.size(); i++) {
                ts.add(ali.get(i));
                count++;
            }
        }
        int[] result = new int[num];

        int cc = 0;
        for (Integer i : ts) {
            result[cc] = i;
            cc++;
        }

        return result;
    }


    public static void main(String[] args) {
        int maxDepth = new Solution3().getMaxDepth("((()))()(())");
        System.out.println(maxDepth);
    }
}
