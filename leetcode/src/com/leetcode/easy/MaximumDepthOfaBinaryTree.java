package com.leetcode.easy;

import java.util.ArrayDeque;

import com.leetcode_daily_challenge.TreeNode;

public class MaximumDepthOfaBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int maxDepthIterativeDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var stack = new ArrayDeque<TreeNode>();
        var depths = new ArrayDeque<Integer>();

        stack.push(root);
        depths.push(1);

        int depth = 0, currentDepth = 0;
        while (!stack.isEmpty()) {
            root = stack.pop();
            currentDepth = depths.pop();
            depth = Math.max(depth, currentDepth);
            if (root.left != null) {
                stack.push(root.left);
                depths.push(currentDepth + 1);
            }
            if (root.right != null) {
                stack.push(root.right);
                depths.push(currentDepth + 1);
            }
        }
        return depth;
    }

    public int maxDepthIterativeBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        var queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return depth;
    }
}
