package com.cjcui.algorithm;

public class LinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        ListNode listNode = new LinkedList().reverseList(n1);
//        ListNode listNode = new LinkedList().reverseList2(n1);
//        ListNode listNode = new LinkedList().reverseList3(n1);
        ListNode listNode = new LinkedList().reverseList4(n1);

    }

    public ListNode reverseList(ListNode head) {
        if (head.next != null) {
            head.next.pre = head;
            reverseList(head.next);
        } else {
        }
        return head;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode temNode = head;
        while (temNode.next != null) {
            temNode.next.pre = temNode;
            temNode = temNode.next;
        }
        return temNode;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode newHead = reverseList3(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }


    public ListNode reverseList4(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev; // 翻转箭头
            prev = curr; //三人行
            curr = nxt; //三人行
        }

        return prev;
    }


    static class ListNode {
        ListNode pre;
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val, ListNode pre, ListNode next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
}