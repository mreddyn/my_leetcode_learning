package com.leetcode_daily_challenge;

public class DoubleANumberRepresentedAsLinkedList {
    private ListNode doubleIt(ListNode head) {
        ListNode reversedList = reverseLinkedList(head);
        int carry = 0;
        ListNode current = reversedList, previous = null;
        while (current != null) {
            int newValue = current.val * 2 + carry;
            current.val = newValue % 10;

            if (newValue > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            previous = current;
            current = current.next;
        }

        // if carry is not equal to zero
        if (carry != 0) {
            ListNode extraNode = new ListNode(carry);
            previous.next = extraNode;
        }

        ListNode result = reverseLinkedList(reversedList);
        return result;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode node, temp;
        node = null;
        temp = null;
        while (head != null) {
            node = head.next;
            head.next = temp;
            temp = head;
            head = node;
        }
        return temp;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
