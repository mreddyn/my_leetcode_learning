package com.leetcode_daily_challenge;
public class LinkedListCycle {
    private boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow,fast;
        slow = head;
        fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}

/*
 * scshape
 * 
 */