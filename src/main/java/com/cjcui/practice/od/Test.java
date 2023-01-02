package com.cjcui.practice.od;


public class Test {
    String str = new String("good");
    char ch[] = {'A'};

    public static void main(String[] args) {
        /*
         * Float f = new Float("12"); switch (f) { case 12:
         *
         * break;
         *
         * default: break; }
         */

        Test t = new Test();
        t.change(t.str, t.ch);
        System.out.println(t.str);
        System.out.println(t.ch[0]);
    }

    public void change(String str, char[] ch) {
//        str = " test ok";
//        ch[0] = 'g';
//        try {
//            System.exit(1);
//        } catch (Exception e) {
//            // TODO: handle exception
//            System.out.println("exit");
//        }
        Integer str1 = 123;
        String star2 = str + 456;
        int a = 1;
        switch (a) {
            case 2:
                System.out.println(2);
            case 4:
                System.out.println(4);
                break;
            default:
                System.out.println("default");
            case 6:
                System.out.println("333333333333");
        }
    }


}
