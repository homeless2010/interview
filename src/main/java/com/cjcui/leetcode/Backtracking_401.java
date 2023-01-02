package com.cjcui.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Backtracking_401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" + m : "") + m);
                }
            }
        }
        return ans;
    }

    public List<String> readBinaryWatch2(int turnedOn) {
        return null;
    }

    private void backtrace(int path, int idx, int len, int total, List<String> res) {
        if (total == 0) {
            String r = convert(path);
            if (!"".equals(r)) {
                res.add(r);
            }
            return;
        }
        if (len - idx < total) {
            return;
        }
        backtrace(path, idx + 1, len, total, res);
    }

    private String convert(int num) {
        int hour = (num & 0b1111000000) >>> 6;
        int minute = (num & 0b111111);
        if (hour >= 12) {
            return "";
        }
        if (minute > 59) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(hour + ":");
        if (minute < 10) {
            sb.append("0");
        }
        sb.append(minute);
        return sb.toString();
    }
}
