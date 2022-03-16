package com.cjcui;

public class Multiply {

    public static void main(String[] args) {
        multiply("11", "11");
    }

    public static String multiply(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int[][] values = new int[charsB.length][charsA.length + 1];
        for (int j = charsB.length; j > 0; j--) {
            int quotient = 0;
            for (int i = charsA.length; i >= 0; i--) {
                if (i == 0) {
                    values[charsB.length - j][i] = quotient;
                    continue;
                }
                int multiply = Integer.valueOf(String.valueOf(charsA[i - 1])) * Integer.valueOf(String.valueOf(charsB[j - 1]));
                values[charsB.length - j][i] = (multiply + quotient) % 10;
                quotient = (multiply + quotient) / 10;
            }
        }
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
            }

        }
        System.out.println(values);
        return null;
    }
}
