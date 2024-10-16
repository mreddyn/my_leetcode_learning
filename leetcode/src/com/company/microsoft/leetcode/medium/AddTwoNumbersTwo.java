package com.company.microsoft.leetcode.medium;

import com.leetcode_daily_challenge.ListNode;

public class AddTwoNumbersTwo {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
         * Reverse the two lists and add them.
         * after adding reverse the result list and return
         */
        ListNode reversedListOneHead = reverseLinkedList(l1);
        ListNode reversedListTwoHead = reverseLinkedList(l2);
        ListNode resultList = addTwoLists(reversedListOneHead, reversedListTwoHead);
        ListNode reversedResultListHead = reverseLinkedList(resultList);

        return reversedResultListHead;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode temp = null, node = null;
        while (head != null) {
            node = head.next;
            head.next = temp;
            temp = head;
            head = node;
        }

        return temp;
    }

    private ListNode addTwoLists(ListNode l1, ListNode l2) {
        int sum = 0, carry = 0, remainder = 0;
        ListNode node, dummyHead = new ListNode(0);
        node = dummyHead;
        while (l1 != null || l2 != null || carry > 0) {
            ListNode cur = new ListNode(0);
            sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            remainder = sum % 10;
            cur.val = remainder;
            dummyHead.next = cur;
            dummyHead = dummyHead.next;
        }

        return node.next;
    }
}
