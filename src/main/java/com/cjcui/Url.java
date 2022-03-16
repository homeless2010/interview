package com.cjcui;

import javax.swing.*;

public class Url {

    public static void main(String[] args) {
        System.out.println(new Url().replaceSpaces("Mr John Smith    ", 13));
    }

    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        char[] returnChar = new char[3 * length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (' ' == chars[i]) {
                returnChar[index] = '%';
                returnChar[index + 1] = '2';
                returnChar[index + 2] = '0';
                index += 3;
            } else {
                returnChar[index] = chars[i];
                index++;
            }
        }
        char c1 = '\u0000';
        String s = new String(returnChar);
        return s.substring(0,index);
    }
}
