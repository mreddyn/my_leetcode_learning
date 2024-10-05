package com.company.facebook.medium;

import com.leetcode_daily_challenge.ListNode;

public class ReverseLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /*
         * 
         */
        if (head == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        // create a pointer as a marker for the node before reversing
        ListNode pre = dummy;
        dummy.next = head;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next; // a pointer to the beginning of the sub-list that will be reversed
        ListNode then = start.next; // a pointer to the node that will be reversed

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
