package com.leetcode.easy;

import java.util.TreeMap;

import com.leetcode_daily_challenge.ListNode;

public class LinkedListFrequency {
    public ListNode frequenciesOfElements(ListNode head) {
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();
        while (head != null) {
            int key = head.val;
            frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
            head = head.next;
        }

        ListNode node, dummyNode;
        node = new ListNode(0);
        dummyNode = node;
        for (int key : frequencyMap.keySet()) {
            int freq = frequencyMap.get(key);
            node.next = new ListNode(freq);
            node.next = node.next.next;
        }
        return dummyNode.next;
    }
}
