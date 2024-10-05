package com.leetcode.easy;

public class ConvertDoublyLinkedListToArrayOne {
    public int[] toArray(Node head) {
        // count the number of nodes
        int totalNodes = 0;
        Node node = head;
        while (node != null) {
            totalNodes++;
            node = node.next;
        }

        var resultArray = new int[totalNodes];
        int index = 0;
        node = head;
        while (node != null) {
            resultArray[index++] = node.val;
            node = node.next;
        }
        return resultArray;
    }

    // Definition for a Node.
    class Node {
        private int val;
        public Node prev;
        public Node next;
    };
}
