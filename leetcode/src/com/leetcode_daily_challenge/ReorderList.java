package com.leetcode_daily_challenge;

public class ReorderList {
    private void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // find middle of linkedList
        // reverse the linkedList
        // Merge two sorted lists
        ListNode middleNode = middleOfLinkedList(head);
        ListNode secondListHead = reverseLinkedList(middleNode);
        mergeTwoLinkedLists(head, secondListHead);

    }

    private ListNode middleOfLinkedList(ListNode head) {
        ListNode slow, fast;
        slow = head;
        fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode node, temp;
        node = null;
        temp = null;
        while (head != null) {
            node = head.next;
            head.next = temp;
            temp = head;
            head = node;
        }
        return temp;
    }

    private void mergeTwoLinkedLists(ListNode first, ListNode second) {
        ListNode temp = null;
        while (second != null) {
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
