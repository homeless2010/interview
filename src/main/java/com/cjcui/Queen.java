package com.cjcui;

import java.util.LinkedList;

/**
 * @author cjcui
 * @date 2021/07/16
 */
public class Queen {
    public void queen() {
        LinkedList linkedList = new LinkedList();
        boolean offer = linkedList.offer("");
        Object peek = linkedList.peek();
        Object poll = linkedList.poll();
        linkedList.push("");
        Object pop = linkedList.pop();
    }
}
