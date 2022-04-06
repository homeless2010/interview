package com.cjcui.leetcode;

/**
 * 反转链表
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = new ReverseLinkedList().reverseLinkedList2(l1);
    }

    //递归
    ListNode reverseLinkedList2(ListNode listNode) {
        if (listNode.next == null) {
            return listNode;
        }
        ListNode next = listNode.next;
        next.next = reverseLinkedList2(next.next);
        return listNode;
    }

    //指针
    ListNode reverseLinkedList(ListNode listNode) {
        ListNode preHead = null;
        ListNode curr = listNode;
        while (curr.next != null) {
            ListNode next = curr.next;
            curr.next = preHead;
            preHead = curr;
            curr = next;
        }
        curr.next = preHead;
        return curr;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
