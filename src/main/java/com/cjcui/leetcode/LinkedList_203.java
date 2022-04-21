package com.cjcui.leetcode;

public class LinkedList_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null;
        ListNode newHead = head;
        while (head != null) {
            if (head.val == val && pre != null) {
                 head = pre.next.next;
            }
            if (head.next != null && head.next.val == val) {
                head.next = head.next.next;
            }
            pre = head;
            head = head.next;
        }
        return newHead;
    }
}