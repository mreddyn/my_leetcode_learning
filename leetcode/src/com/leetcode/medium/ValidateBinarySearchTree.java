package com.leetcode.medium;

import java.util.ArrayDeque;

import com.leetcode_daily_challenge.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }

        if (root.val > minVal && root.val < maxVal) {
            return isValidBSTHelper(root.left, minVal, root.val) && isValidBSTHelper(root.right, root.val, maxVal);
        } else {
            return false;
        }
    }

    public boolean isValidBSTIterativeBFS(TreeNode root) {
        if (root == null) {
            return true;
        }

        var queue = new ArrayDeque<BSTValid>();
        queue.offer(new BSTValid(root, Long.MIN_VALUE, Long.MAX_VALUE));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                BSTValid bst = queue.poll();
                TreeNode node = bst.node;
                if (node.val > bst.minVal && node.val < bst.maxVal) {
                    if (node.left != null) {
                        queue.offer(new BSTValid(node.left, bst.minVal, node.val));
                    }

                    if (node.right != null) {
                        queue.offer(new BSTValid(node.right, node.val, bst.maxVal));
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    class BSTValid {
        TreeNode node;
        long minVal;
        long maxVal;

        BSTValid(TreeNode node, long minVal, long maxVal) {
            this.node = node;
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }
}
