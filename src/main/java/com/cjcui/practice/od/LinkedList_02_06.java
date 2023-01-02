package com.cjcui.practice.od;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 */
public class LinkedList_02_06 {
    public boolean isPalindrome(ListNode head) {
        ListNode tempNode = head;
        StringBuilder s1 = new StringBuilder();
        while (tempNode != null) {
            s1.append(tempNode.val);
            tempNode = tempNode.next;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        StringBuilder s2 = new StringBuilder();
        while (pre != null) {
            s2.append(pre.val);
            pre = pre.next;
        }
        return s1.toString().equals(s2.toString());
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(0);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
        boolean palindrome = new LinkedList_02_06().isPalindrome(listNode1);
    }
}
