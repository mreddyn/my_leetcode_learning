package com.leetcode.medium;

import com.leetcode_daily_challenge.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        /*
         * 1. Find the middle node of linkedList, if there two middle nodes return
         * second one.
         * 2. Reverse the second part of the list
         * 3. merge two lists
         */

    }

    private ListNode middleOfLinkedList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode temp = null, node = null;
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
