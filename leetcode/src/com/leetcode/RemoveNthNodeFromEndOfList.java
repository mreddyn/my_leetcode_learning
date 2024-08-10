package com.leetcode;

import com.leetcode_daily_challenge.ListNode;

public class RemoveNthNodeFromEndOfList {
    private ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        int size = getSizeOfLinkedList(head);
        int ithNodeFromStart = size - n;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        for (int i = 1; i <= ithNodeFromStart; i++) {
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummyNode.next;
    }

    private int getSizeOfLinkedList(ListNode head) {
        if (head == null) {
            return 0;
        }
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
