package com.company.goldmanSachs;

import java.util.HashMap;
import java.util.Map;

import com.leetcode_daily_challenge.ListNode;

public class RemoveDuplicatesFromUnsortedLinkedList {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        ListNode node = head;
        // insert values into HashMap to keep track of duplicate nodes
        while (node != null) {
            int val = node.val;
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
            node = node.next;
        }

        // iterate through the LinkedList and check for val frequency in HashMap,
        // if it is greater than 1 then delete that node
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        node = dummyHead;
        while (node.next != null) {
            int val = node.next.val;
            int frequency = freqMap.get(val);
            if (frequency > 1) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return dummyHead.next;
    }
}
