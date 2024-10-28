package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

import com.leetcode_daily_challenge.TreeNode;

public class KthLargestSumInaBinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        /*
         * maintain a PriorityQueue to keep k sums that are acquired from doing
         * BFS level by level
         */
        var totalLevels = 0;
        var queue = new ArrayDeque<TreeNode>();
        var pQueue = new PriorityQueue<Long>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long curLevelSum = 0;
            totalLevels++;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                curLevelSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            pQueue.add(curLevelSum);
            while (pQueue.size() > k) {
                pQueue.poll();
            }
        }
        // if total numbers of levels is less than k, then return -1
        if (totalLevels < k) {
            return -1;
        }
        return pQueue.peek();
    }
}
