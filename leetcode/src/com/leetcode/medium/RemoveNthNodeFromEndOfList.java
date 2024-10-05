package com.leetcode.medium;

import com.leetcode_daily_challenge.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow, fast, start = new ListNode(0);
        start.next = head;
        slow = start;
        fast = start;
        for (int i = 1; i <= n + 1; i++) {
            // move fast pointer in front so that gap between slow and fast becomes n
            fast = fast.next;
        }

        // move fast to end, while maintaining the gap
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // skip the node
        slow.next = slow.next.next;

        return start.next;
    }
}
