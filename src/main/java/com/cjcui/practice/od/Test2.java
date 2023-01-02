package com.cjcui.practice.od;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Test2 {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a.equals(b));
        System.out.println(a == b);
        Callable<Integer> callable = () -> {
            Thread.sleep(1000);
            return 100;

        };

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
//        Path path = Paths.get();
//        executorService.schedule()
//        Paths.get()
    }

}
