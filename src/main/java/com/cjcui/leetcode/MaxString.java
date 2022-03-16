package com.cjcui.leetcode;

import java.util.*;

/**
 * 最长字符串（无重复）
 */
public class MaxString {
    public static void main(String[] args) {
        int abcabcbb = new MaxString().lengthOfLongestSubstring(" ");
        System.out.println(abcabcbb);
    }

    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int begin = 0;
        int len = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                int index = s.indexOf(chars[i], begin);
                begin = index + 1;
                i = index;
                set.clear();
                len = 0;
            } else {
                set.add(chars[i]);
                len += 1;
                list.add(len);
            }
        }
//        Optional<Integer> max = list.stream().max(Integer::compare);
//        return max.get();
//        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
//        return collect.get(collect.size() - 1);
        Integer[] fdsfdf = new Integer[list.size()];
        list.toArray(fdsfdf);
        Arrays.sort(fdsfdf);
        System.out.println(fdsfdf.length);
        return fdsfdf[fdsfdf.length - 1];
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int b = 0;
        int e = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (e + 1 < length && !set.contains(s.charAt(e + 1))) {
                set.add(s.charAt(e + 1));
                ++e;
            }
            b = Math.max(b, e - i + 1);
        }
        return b;


    }
}
