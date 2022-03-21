package com.cjcui.leetcode;

public class String_1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == chars[i]) {
                    max = Math.max(max, j - i - 1);
                }
            }
        }
        return max;
    }
}
