package com.cjcui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数学表达式
 */
public class Expression {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

    }

    void helper(String s, int value, List list, StringBuilder sb, int pos, int currVal) {
        if (currVal == value) {
            list.add(sb);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            
        }
    }
}
