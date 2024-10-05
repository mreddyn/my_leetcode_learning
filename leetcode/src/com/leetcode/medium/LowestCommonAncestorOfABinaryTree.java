package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

import com.leetcode_daily_challenge.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // look for nodes p and q in left and right sub trees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            // p and q are in different sub trees
            return root;
        }

        if (left == null) {
            // p and q are in right subtree
            return right;
        }

        if (right == null) {
            // p and q are in left subtree
            return left;
        }

        return null;
    }

    public TreeNode lowestCommonAncestorIterativeBFS(TreeNode root, TreeNode p, TreeNode q) {
        // Map to store parent and child relationship
        var parent = new HashMap<TreeNode, TreeNode>();
        // queue for Tree Traversal
        var queue = new ArrayDeque<TreeNode>();
        parent.put(root, null);
        queue.offer(root);

        // Iterate until we find p and q nodes
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                // while traversing keep saving parent pointers
                parent.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }

        // Ancestor set for p
        var pAncestors = new HashSet<TreeNode>();

        // process all ancestors of node p until null
        while (p != null) {
            pAncestors.add(p);
            p = parent.get(p);
        }

        // now the first ancestor of q which appears in p's ancestors is
        // their lowest common ancestor
        while (!pAncestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}
