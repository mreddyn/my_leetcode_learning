package com.leetcode.easy;

import com.leetcode_daily_challenge.ListNode;

public class DeleteNModesAfterMNodesInLinkedList {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode mNodePointer = head, nNodePointer = head;
        int mNodesCount = 0, nNodesCount = 0;
        while (mNodePointer != null && nNodePointer != null) {
            mNodesCount = 0;
            nNodesCount = 0;

            // count m nodes
            while (mNodePointer != null) {
                mNodesCount++;
                if (mNodesCount == m) {
                    break;
                }
                mNodePointer = mNodePointer.next;
            }

            // now count n nodes
            if (mNodePointer == null) {
                break;
            }
            nNodePointer = (mNodePointer != null) ? mNodePointer.next : null;
            while (nNodePointer != null) {
                nNodesCount++;
                if (nNodesCount == n) {
                    break;
                }
                nNodePointer = nNodePointer.next;
            }

            // point mNodePointer.next to nNodePointer.next and continue
            mNodePointer.next = (nNodePointer != null) ? nNodePointer.next : null;
            mNodePointer = mNodePointer.next;
        }
        return head;
    }

    public ListNode deleteNodesApproachTwo(ListNode head, int m, int n) {
        ListNode currentNode = head, lastMNode = head;
        while (currentNode != null) {
            // init mCount = m, and nCount = n
            int mCount = m, nCount = n;

            // traverse m nodes
            while (currentNode != null && mCount != 0) {
                mCount--;
                lastMNode = currentNode;
                currentNode = currentNode.next;
            }

            // once we counted m nodes, then we need to count n nodes
            while (currentNode != null && nCount != 0) {
                nCount--;
                currentNode = currentNode.next;
            }

            // delete n nodes
            lastMNode.next = currentNode;
        }

        return head;
    }
}
