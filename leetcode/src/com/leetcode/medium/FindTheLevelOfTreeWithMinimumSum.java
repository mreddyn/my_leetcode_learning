package com.leetcode.medium;

import java.util.ArrayDeque;

import com.leetcode_daily_challenge.TreeNode;

public class FindTheLevelOfTreeWithMinimumSum {
    public int minimumLevel(TreeNode root) {
        int minLevel = Integer.MAX_VALUE, curLevel = 0;
        long minLevelSum = Long.MAX_VALUE;
        var queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            curLevel++;
            long curLevelSum = 0;
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

            if (minLevelSum > curLevelSum) {
                minLevelSum = curLevelSum;
                minLevel = curLevel;
            }
        }

        return minLevel;
    }
}
