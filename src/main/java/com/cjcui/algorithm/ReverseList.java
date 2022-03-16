package com.cjcui.algorithm;

public class ReverseList {
    public static void main(String[] args) {
        Node node = new Node(2);
        Node node1 = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        Node node4 = new Node(6);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node node5 = new ReverseList().reverseLinkedList(node);
    }

    public Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node node1 = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
        return node1;
    }

    public Node reverseLinkedList2(Node node) {
        Node pre = null;
        Node curr = node;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
