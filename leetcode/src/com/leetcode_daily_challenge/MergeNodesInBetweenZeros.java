package com.leetcode_daily_challenge;

public class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        int consecutiveSum = 0;
        while (head.next != null) {
            if (head.val == 0) {
                node.val = consecutiveSum;
                node.next = new ListNode(0);
                node = node.next;
                consecutiveSum = 0;
            } else {
                consecutiveSum += head.val;
            }
            head = head.next;
        }
        if (consecutiveSum != 0) {
            node.val = consecutiveSum;
        }

        return dummyHead.next;
    }
}
