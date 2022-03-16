package com.cjcui;

/***
 * java switch贯穿
 */
public class Test {
    public static void main(String[] args) {
        new Test().dddd();
    }

    void dddd() {
        int i = 0;
        switch (i) {
            default:
                System.out.println("default");
            case 1:
                System.out.println("111111111111111111111");
//                break;
//            case 0:
//                System.out.println("000000000000000");
            case 5:
                System.out.println("555555555555555");
//                break;
        }
    }
}
