package com.cjcui.design;

import java.util.PriorityQueue;
import java.util.Queue;

public class Queen {
    public static void main(String[] args) {
        Queue queue = new PriorityQueue();
        queue.offer(1);
        queue.offer(4);
        queue.offer(2);
        Object peek = queue.peek();
        System.out.println(peek);
        Object peek2 = queue.peek();
        System.out.println(peek);
    }
}
