package com.leetcode_daily_challenge;

public class PalindromeLinkedList {
    private boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow, fast;
        slow = head;
        fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) { // odd nodes
            slow = slow.next;
        }
        slow = reverseLinkedList(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode temp, node;
        temp = null;
        node = null;
        while (head != null) {
            node = head.next;
            head.next = temp;
            temp = head;
            head = node;
        }
        return temp;
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(2);
        first.next.next.next = new ListNode(1);
        first.next.next.next.next = null;
        System.out.println(palindromeLinkedList.isPalindrome(first));
    }
}
