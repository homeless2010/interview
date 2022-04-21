package practice.test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class Leetcode234 {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            stack.push(head.val);
            head = head.next;
        }
        int index = 0;
        while (stack.peek() != null) {
            if (stack.pop() != (sb.charAt(index) - '0')) {
                return false;
            }
            index++;
        }
        return true;
    }
}
