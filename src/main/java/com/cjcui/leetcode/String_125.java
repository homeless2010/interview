package com.cjcui.leetcode;

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
}
