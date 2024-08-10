package com.leetcode_daily_challenge;

import java.util.ArrayDeque;
import java.util.Iterator;

public class RemoveNodesFromLinkedList {
    private ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        ListNode node = head;
        /*
         * Iterate through the list, maintain a stack to keep nodes of those where
         * current node value is greater
         * than the node on top of stack
         * After done with iterating, maintain a iterator on stack reversely
         */
        while (node != null) {
            if (stack.isEmpty()) {
                stack.push(node);
            } else {
                while (!stack.isEmpty() && stack.peek().val < node.val) {
                    stack.pop();
                }
                stack.push(node);
            }
            node = node.next;
        }
        Iterator<ListNode> iterator = stack.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().val);
        }
        ListNode newHead = new ListNode(0);
        ListNode tempHead = newHead;
        while (iterator.hasNext()) {
            ListNode curNode = iterator.next();
            newHead.next = curNode;
            newHead = newHead.next;
        }
        return tempHead.next;
    }

    private ListNode removeNodesApproachTwo(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = removeNodesApproachTwo(head.next);
        if (head.val < nextNode.val) {
            return nextNode;
        }
        head.next = nextNode;
        return head;
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

    public static void main(String[] args) {
        RemoveNodesFromLinkedList rFromLinkedList = new RemoveNodesFromLinkedList();
        rFromLinkedList.removeNodes(null);
        rFromLinkedList.removeNodesApproachTwo(null);
    }
}
