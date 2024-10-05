package com.leetcode.medium;

import com.leetcode_daily_challenge.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        if ((p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)) {
            // p and q are in different sub tree
            return root;
        }

        if (p.val > root.val && q.val > root.val) {
            // p and q are in same subtree (right subtree)
            return lowestCommonAncestor(root.right, p, q);
        }
        return lowestCommonAncestor(root.left, p, q);
    }
}
