package com.company.doordash;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RemoveSmallestLocalPeaksInorder {
    // Doubly linked list node representation
    static class Node {
        int val;
        Node left;
        Node right;
        boolean removed;

        Node(int val) {
            this.val = val;
        }
    }

    public static List<Integer> removePeaks(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        int n = nums.length;
        // Create nodes and link them as a doubly linked list
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                nodes[i].left = nodes[i - 1];
            }
            if (i < n - 1) {
                nodes[i].right = nodes[i + 1];
            }
        }

        // PriorityQueue to keep the peaks sorted by their value
        PriorityQueue<Node> peakPQ = new PriorityQueue<>((a, b) -> (Integer.compare(a.val, b.val)));

        // Initially add all nodes that are peaks to the PQ
        for (int i = 0; i < n; i++) {
            if (isPeak(nodes[i])) {
                peakPQ.offer(nodes[i]);
            }
        }

        // Keep count of remaining nodes in the list
        int remaining = n;
        while (remaining > 0) {
            Node cur = peakPQ.poll();
            if (cur == null) {
                break; // Should not occur if there is at least one element remaining.
            }
            // Verify that the node has not been removed and is still a peak.
            if (cur.removed || !isPeak(cur)) {
                continue;
            }
            // Remove the current peak.
            cur.removed = true;
            result.add(cur.val);
            remaining--;

            // Update the doubly linked list pointers.
            Node left = cur.left;
            Node right = cur.right;
            if (left != null) {
                left.right = right;
            }
            if (right != null) {
                right.left = left;
            }

            // After removal, check if the immediate neighbors now qualify as peaks.
            if (left != null && !left.removed && isPeak(left)) {
                peakPQ.offer(left);
            }
            if (right != null && !right.removed && isPeak(right)) {
                peakPQ.offer(right);
            }
        }

        return result;
    }

    // Helper method to check if a node is a peak based on its neighbors.
    private static boolean isPeak(Node node) {
        if (node == null || node.removed)
            return false;
        // A single element is a peak.
        if (node.left == null && node.right == null)
            return true;
        // First element: check against right neighbor.
        if (node.left == null)
            return node.val > node.right.val;
        // Last element: check against left neighbor.
        if (node.right == null)
            return node.val > node.left.val;
        // Otherwise, a peak if it is greater than both neighbors.
        return node.val > node.left.val && node.val > node.right.val;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 1, 4, 2 };
        List<Integer> result = removePeaks(nums);
        System.out.println(result); // Expected output: [4, 2, 5, 3, 1]
    }
}
