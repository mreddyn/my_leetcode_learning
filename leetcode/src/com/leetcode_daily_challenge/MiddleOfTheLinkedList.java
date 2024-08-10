package com.leetcode_daily_challenge;

public class MiddleOfTheLinkedList {
    private ListNode middleNode(ListNode head) {
        int size = sizeOfLinkedList(head);
        int middleNode = (size/2)+1;
        ListNode node = head;
        while(middleNode > 0 && node != null){
            node = node.next;
            middleNode--;
        }
        return node;
    }

    private int sizeOfLinkedList(ListNode head){
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
