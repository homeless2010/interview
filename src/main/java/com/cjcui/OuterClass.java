package com.cjcui;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class OuterClass {
    //    public final String a = "ddddddd";
    public final int a = 11;

    public OuterClass() {
    }

    public static OuterClass sss(final int name) {
        return new OuterClass() {
            final int s = 222;

            public void display() {
                System.out.println(name);
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("file.encoding"));
        int f = 333;
        OuterClass ssss = sss(f);
        Method[] methods = ssss.getClass().getMethods();
        try {
            methods[0].invoke(ssss);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Field[] declaredFields = ssss.getClass().getDeclaredFields();
        OuterClass outerClass = new OuterClass();
        Field[] declaredFields1 = outerClass.getClass().getDeclaredFields();
        Class<?> type1 = declaredFields1[0].getType();
        System.out.println(type1);
        declaredFields1[0].setAccessible(true);

        try {
            declaredFields1[0].set(outerClass, 2);
            System.out.println("哈哈: " + outerClass.a);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Field declaredField = declaredFields[0];
        Class<?> type = declaredField.getType();
        System.out.println(type);
        int i = declaredField.getModifiers() & ~Modifier.FINAL;
        int modifiers = declaredField.getModifiers();
        System.out.println(modifiers & 1);
        System.out.println(modifiers & 2);
        System.out.println(modifiers & 8);
        System.out.println(modifiers & 16);
        System.out.println(Modifier.isFinal(modifiers));
        System.out.println(Modifier.isPrivate(modifiers));
        try {
            Object o = declaredField.get(ssss);
            System.out.println(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        declaredField.setAccessible(true);
        try {
            declaredField.set(ssss, 77777);
            Object o = declaredField.get(ssss);
            System.out.println(o);
            try {
                methods[0].invoke(ssss);
                System.out.println(f);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

//    public void display(final String name, String age) {
//        class InnerClass {
//            void display() {
//                System.out.println(name);
//            }
//        }
//    }

    static class Cat {

    }

}