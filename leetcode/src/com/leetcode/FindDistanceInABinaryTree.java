package com.leetcode;

import com.leetcode_daily_challenge.TreeNode;

public class FindDistanceInABinaryTree {
    public int findDistance(TreeNode root, int p, int q) {
        /*
         * to find distance between any nodes in a binary tree, the path has to go
         * through LCA
         * LCA : Least Common Ancestor of two nodes
         * We will find the node which is a LCA and travel to p and q separately from
         * LCA
         */
        int[] distance = new int[1];
        TreeNode leastCommonAncestor = findLowestCommonAncestor(root, p, q);

        calculateDistanceFromLCAToTarget(leastCommonAncestor, p, distance);
        calculateDistanceFromLCAToTarget(leastCommonAncestor, q, distance);

        return distance[0];
    }

    private TreeNode findLowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = findLowestCommonAncestor(root.left, p, q);
        TreeNode right = findLowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return null;
    }

    private boolean calculateDistanceFromLCAToTarget(TreeNode node, int targetValue, int[] distance) {
        if (node == null) {
            return false;
        }
        if (node.val == targetValue) {
            return true;
        }
        // travel left subtree
        distance[0]++;
        if (calculateDistanceFromLCAToTarget(node.left, targetValue, distance)) {
            return true;
        }
        distance[0]--;

        // travel right subtree
        distance[0]++;
        if (calculateDistanceFromLCAToTarget(node.right, targetValue, distance)) {
            return true;
        }
        distance[0]--;
        return false;
    }
}
