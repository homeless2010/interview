package com.cjcui.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/substrings-of-size-three-with-distinct-characters/
 */
public class SlidingWindow_1876 {
    public static void main(String[] args) {
        new SlidingWindow_1876().countGoodSubstrings("aababcabc");
    }

    public int countGoodSubstrings(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 3; j <= s.length(); i++, j = i + 3) {
            String substring = s.substring(i, j);
            System.out.println(substring);
            set.add(substring.charAt(0));
            set.add(substring.charAt(1));
            set.add(substring.charAt(2));
            if (set.size() == 3) {
                count++;
            }
            set.clear();
        }
        return count;
    }
}
