package com.leetcode_daily_challenge;

public class RemoveNthNodeFromEndOfList {
    private ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSizeOfLinkedList(head);
        int nthNodeFromStart = size - n;
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        ListNode first = dummyHead;
        while (nthNodeFromStart > 0) {
            nthNodeFromStart--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummyHead.next;
    }

    private int getSizeOfLinkedList(ListNode head) {
        if (head == null) {
            return 0;
        }
        int size = 0;
        while (head.next != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        second.next = null;
        removeNthNodeFromEndOfList.removeNthFromEnd(first, 1);
    }

}
