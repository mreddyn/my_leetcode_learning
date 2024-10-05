package com.leetcode.easy;

import java.util.ArrayDeque;

import com.leetcode_daily_challenge.TreeNode;

public class SecondMinimumNodeInaBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        /*
         * Find the first value that is just larger than the root node value from left
         * subtree and right subtree.
         * Take the base case as if(root == NULL) {return -1;}
         * If one of them is -1, return the other value else return the minimum from
         * both of them.
         */
        return secondMinimum(root, root.val);
    }

    private int secondMinimum(TreeNode root, int minVal) {
        if (root == null) {
            return -1;
        }

        if (root.val > minVal) {
            return root.val;
        }

        int leftSubTreeSecondMin = secondMinimum(root.left, root.val);
        int rightSubTreeSecondMin = secondMinimum(root.right, root.val);
        if (leftSubTreeSecondMin == -1) {
            return rightSubTreeSecondMin;
        } else if (rightSubTreeSecondMin == -1) {
            return leftSubTreeSecondMin;
        } else {
            return Math.min(leftSubTreeSecondMin, rightSubTreeSecondMin);
        }
    }

    public int findSecondMinimumValueIterativeBFS(TreeNode root) {
        if (root == null) {
            return -1;
        }

        var queue = new ArrayDeque<Pair>();
        queue.offer(new Pair(root, root.val));
        long secondMin = Long.MAX_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int minVal = pair.minVal;
                if (node.val > minVal) {
                    secondMin = Math.min(secondMin, node.val);
                }

                if (node.left != null) {
                    queue.offer(new Pair(node.left, node.val));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, node.val));
                }
            }
        }

        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }

    class Pair {
        TreeNode node;
        int minVal;

        Pair(TreeNode node, int minVal) {
            this.node = node;
            this.minVal = minVal;
        }
    }

}
