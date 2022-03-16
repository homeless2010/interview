package com.cjcui.leetcode;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(0 + '0');
        System.out.println('0' + 1);
        System.out.println(1 % 2);
    }

    public String addBinary(String a, String b) {
        StringBuffer str = new StringBuffer();
        int max = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < max; i++) {
            carry += (i < a.length()) ? a.charAt(a.length() - i - 1) - '0' : 0;
            carry += (i < b.length()) ? b.charAt(b.length() - i - 1) - '0' : 0;
            int i1 = carry % 2;
            str.append(i1);
            carry /= 2;
        }
        if (carry > 0) {
            str.append(1);
        }
        StringBuffer reverse = str.reverse();
        return reverse.toString();
    }
}
