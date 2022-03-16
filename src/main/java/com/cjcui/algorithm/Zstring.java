package com.cjcui.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * z形字符串
 */
public class Zstring {
    public String convert(String s, int numRows) {
        List<List<String>> list = new ArrayList<>();
        int length = s.length();
        //计算列数
        int col = numRows - 2;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (((i + 1) % col) == 0) {
                for (int j = 0; j < numRows; j++) {

                }
            } else {
                List<String> colList = new ArrayList<>();
                colList.add(String.valueOf(chars[i]));
            }
        }
        return "";
    }
}
