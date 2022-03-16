package com.cjcui.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cjcui
 */
public class Str {
    public String addBinary(String a, String b) {
        List<Character> list = new ArrayList<>();
        boolean offset = false;
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        for (int i = 0; i < charsA.length; i++) {
            for (int j = 0; j < charsB.length; j++) {
                int temp = charsA[i] + charsB[j];
                if (temp == 2) {
                    offset = true;
                    list.add('0');
                } else {
                    list.add(String.valueOf(temp).charAt(0));
                }
            }
        }
        return "";
    }
}
