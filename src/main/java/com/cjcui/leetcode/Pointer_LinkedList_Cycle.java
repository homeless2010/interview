package com.cjcui.leetcode;

/**
 * 双指针判断链表是否有环
 */
public class Pointer_LinkedList_Cycle {
    boolean hasCircle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = fast.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
