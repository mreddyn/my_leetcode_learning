package com.company.hubspot.leetcode.easy;

import com.leetcode_daily_challenge.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while (list1 != null && list2 != null) {
            int firstListVal = list1.val;
            int secondListVal = list2.val;
            if (firstListVal < secondListVal) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null) {
            node.next = list1;
        }

        if (list2 != null) {
            node.next = list2;
        }
        return dummyHead.next;
    }
}
