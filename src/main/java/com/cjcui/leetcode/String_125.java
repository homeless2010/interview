package com.cjcui.leetcode;

import java.util.HashMap;
import java.util.Map;

public class String_125 {
    public static void main(String[] args) {
        String s = "d" + 1;
        int d = 'a';
        float f = 1 + 3.1f;
        double h = 1 + 3.1;
//        System.out.println(1 + 3.1);
//        System.out.println(Integer.valueOf('a'));
//        System.out.println(Integer.valueOf('z'));
//        System.out.println(Integer.valueOf('A'));
//        System.out.println(Integer.valueOf('Z'));
//        new String_125().isP("A man, a plan, a canal: Panama");
        boolean p = new String_125().isP("0P");
        System.out.println('\0');
        System.out.println("\0");
        System.out.println(p);
        boolean isomorphic = new String_125().isIsomorphic("paper", "title");
//        boolean isomorphic = new String_125().isIsomorphic("badc", "baba");
        System.out.println(isomorphic);
    }

    public boolean isP(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (((c >= 97) && (c <= 122)) || ((c >= 65) && (c <= 90)) || ((c >= 48) && (c <= 57))) {

            } else {
                chars[i] = '\0';
            }
        }
        String s1 = String.valueOf(chars).replaceAll("\0", "");
        System.out.println(s1);
        String s2;
        int length = s1.length();
        if ((length & 1) == 0) {
            s2 = s1.substring(length / 2, length);
        } else {
            s2 = s1.substring(length / 2 + 1, length);
        }
        for (int i = 0; i < length / 2; i++) {
            if (s1.charAt(i) == s2.charAt(s2.length() - i - 1)) {

            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Map<Character, Character> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(chars1[i])) {
                if (map.get(chars1[i]) == chars2[i]) {

                } else {
                    return false;
                }
            } else {
                if (map.containsValue(chars2[i])) {
                    for (Map.Entry<Character, Character> entry : map.entrySet()) {
                        if (entry.getValue() == chars2[i]) {
                            if (entry.getKey() == chars1[i]) {

                            } else {
                                return false;
                            }
                        }
                    }
                }
                map.put(chars1[i], chars2[i]);
            }
        }
        return true;
    }
}
