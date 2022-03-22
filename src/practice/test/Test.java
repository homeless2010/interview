package practice.test;

import java.io.InputStream;

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
        str = " test ok";
        ch[0] = 'g';
        try {
            System.exit(1);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("exit");
        }
    }

}
