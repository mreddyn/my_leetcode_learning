package com.leetcode.easy;

import com.leetcode_daily_challenge.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        // Given linkedList might have one node, and we may have to delete it.
        // so take a dummyHead
        ListNode node, dummyHead = new ListNode(0);
        dummyHead.next = head;
        node = dummyHead;
        while (dummyHead.next != null) {
            if (dummyHead.next.val == val) {
                dummyHead.next = dummyHead.next.next;
            } else {
                dummyHead = dummyHead.next;
            }
        }

        return node.next;
    }
}
