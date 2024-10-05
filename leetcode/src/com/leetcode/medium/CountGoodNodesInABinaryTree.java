package com.leetcode.medium;

import java.util.ArrayDeque;

import com.leetcode_daily_challenge.TreeNode;

public class CountGoodNodesInABinaryTree {

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int curMax) {
        if (root == null) {
            return 0;
        }
        int goodNodes = root.val >= curMax ? 1 : 0;
        curMax = Math.max(root.val, curMax);
        goodNodes += dfs(root.left, curMax);
        goodNodes += dfs(root.right, curMax);
        return goodNodes;
    }

    public int goodNodesIterativeBFS(TreeNode root) {
        int goodNodesCount = 0;
        if (root == null) {
            return goodNodesCount;
        }

        var queue = new ArrayDeque<Pair>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int maxVal = pair.maxVal;
                if (node.val >= maxVal) {
                    goodNodesCount++;
                }

                if (node.left != null) {
                    queue.offer(new Pair(node.left, Math.max(node.val, maxVal)));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, Math.max(node.val, maxVal)));
                }
            }
        }

        return goodNodesCount;
    }

    class Pair {
        TreeNode node;
        int maxVal;

        Pair(TreeNode node, int maxVal) {
            this.node = node;
            this.maxVal = maxVal;
        }
    }
}
