package com.company.microsoft.leetcode.hard;

import com.leetcode_daily_challenge.ListNode;

public class MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode head = mergeTwoLinkedLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            head = mergeTwoLinkedLists(head, lists[i]);
        }

        return head;
    }

    private ListNode mergeTwoLinkedLists(ListNode listOne, ListNode listTwo) {
        ListNode node, dummyHead = new ListNode(0);
        node = dummyHead;
        while (listOne != null && listTwo != null) {
            int firstListVal = listOne.val;
            int secondListVal = listTwo.val;
            if (firstListVal < secondListVal) {
                node.next = listOne;
                listOne = listOne.next;
            } else {
                node.next = listTwo;
                listTwo = listTwo.next;
            }
            node = node.next;
        }

        // if listOne is not empty
        if (listOne != null) {
            node.next = listOne;
        }

        if (listTwo != null) {
            node.next = listTwo;
        }

        return dummyHead.next;
    }
}
