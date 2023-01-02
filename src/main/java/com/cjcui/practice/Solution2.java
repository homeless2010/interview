package com.cjcui.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int[] getClosestPositions(int[][] positions, int num) {
        int[] ret = new int[num];
        int length = positions.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] arryLegth = new int[length];
        for (int i = 0; i < length; i++) {
            int pointLength = positions[i][0] * positions[i][0] + positions[i][1] * positions[i][1];
            map.put(pointLength, i);
            arryLegth[i] = pointLength;
        }
        Arrays.sort(arryLegth);
        for (int i = 0; i < num; i++) {
            ret[i] = map.get(arryLegth[i]);
        }
        Arrays.sort(ret);
        return ret;
    }

    public int[] getClosestPositions2(int[][] positions, int num) {
        int[] ret = new int[num];
        int length = positions.length;
        int[][] arry = new int[length][2];
        int[] arryLegth = new int[length];
        for (int i = 0; i < length; i++) {
            arry[i][0] = i;
            int pointLength = positions[i][0] * positions[i][0] + positions[i][1] * positions[i][1];
            arry[i][1] = pointLength;
            arryLegth[i] = pointLength;
        }
        Arrays.sort(arryLegth);
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (count == num) {
                break;
            }
            for (int j = 0; j < arry.length; j++) {
                if (arryLegth[i] == arry[j][1]) {
                    ret[count] = arry[j][0];
                    count++;
                }
            }
        }
        Arrays.sort(ret);
        return ret;
    }

    public static void main(String[] args) {
        int[][] a = {{-2, 2}, {2, 2}, {1, 3}, {-1, 3}};
        int[] closestPositions = new Solution2().getClosestPositions(a, 1);
        int i = 10000 * 10000 + -10000 * -10000;
        System.out.println(i);
    }
}
