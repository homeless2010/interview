package com.cjcui.practice;


import java.util.Stack;

public class Stack03_04 {

}

class MyQueue {
    private Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        Integer integer = stack.firstElement();
        stack.remove(0);
        return integer;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.firstElement();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}