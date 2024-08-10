package com.leetcode;

import com.leetcode_daily_challenge.ListNode;

public class DeleteTheMiddleNodeOfLinkedList {
    private ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow, fast, prev;
        slow = head;
        fast = head;
        prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
