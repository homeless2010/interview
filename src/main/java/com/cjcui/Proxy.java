package com.cjcui;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy {

    class Handler implements InvocationHandler {
        Object target;

        public Handler(Object target) {
            super();
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("方法执行前");
            method.invoke(target);
            System.out.println("方法执行后");
            return null;
        }
    }
}
