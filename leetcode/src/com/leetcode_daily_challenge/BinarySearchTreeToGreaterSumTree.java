package com.leetcode_daily_challenge;

import java.util.ArrayDeque;

public class BinarySearchTreeToGreaterSumTree {
    private int pre = 0;

    public TreeNode bstToGstApproachTwo(TreeNode root) {
        int[] freqCount = new int[101];
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        // Get the frequency of Tree nodes
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                freqCount[node.val]++;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        // Do suffix sum
        freqCount[100] = (freqCount[100] > 0) ? 100 : 0;
        for (int i = 99; i >= 0; i--) {
            if (freqCount[i] > 0) {
                freqCount[i] = i + freqCount[i + 1];
            } else {
                freqCount[i] = freqCount[i + 1];
            }
        }

        // print the freqCount array
        for (int i = 0; i < 101; i++) {
            System.out.print(freqCount[i] + " ");
        }

        // Traverse the binary tree and update values based on freqCount array
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                node.val = freqCount[node.val];
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public TreeNode bsTreeNode(TreeNode root) {
        if (root.right != null) {
            bsTreeNode(root.right);
        }
        pre = root.val = pre + root.val;
        if (root.left != null) {
            bsTreeNode(root.left);
        }
        return root;
    }
}
