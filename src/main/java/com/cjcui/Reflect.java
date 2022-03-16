package com.cjcui;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 */
public class Reflect {
    private Reflect() {

    }

    public static void main(String[] args) {
        reflect();
    }

    public static void reflect() {
        Class<Reflect> reflectClass = Reflect.class;
        try {
            Reflect reflect = reflectClass.newInstance();
            System.out.println(reflect);
            try {
//                Constructor<Reflect> constructor = reflectClass.getConstructor();
                Constructor<Reflect> declaredConstructor = reflectClass.getDeclaredConstructor();
                reflectClass.getAnnotatedInterfaces();
                try {
//                    constructor.newInstance();
                    declaredConstructor.newInstance();
                } catch (InvocationTargetException e) {

                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
