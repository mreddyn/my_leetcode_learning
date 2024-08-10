package com.company.microsoft.leetcode.medium;

import com.leetcode_daily_challenge.ListNode;

public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        /*
         * find the (a-1)th node and (b+1)th node
         * we will get the (a-1)th node and insert list2 here.
         * 
         * and traverse list2 to the end and insert (b+1)th node
         */
        ListNode start = null, end = list1;
        // set start to (a-1)th and end to b
        for (int index = 0; index < b; index++) {
            if (index == a - 1) {
                start = end;
            }
            end = end.next;
        }

        // connect the start node to list2
        start.next = list2;

        // traverse the list2 to the end
        while (list2.next != null) {
            list2 = list2.next;
        }

        list2.next = end.next;
        end.next = null;

        return list1;
    }
}
