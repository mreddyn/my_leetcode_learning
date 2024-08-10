package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        /*
         * perform postOrder traversal since it access the tree by visiting left
         * subtree, right subtree,
         * and then root node.
         * 
         */
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>(to_delete.length);
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        root = processNode(root, toDeleteSet, forest);
        // if root is not null, we need to add it to forest
        if (root != null) {
            forest.add(root);
        }

        return forest;
    }

    private TreeNode processNode(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }

        node.left = processNode(node.left, toDeleteSet, forest);
        node.right = processNode(node.right, toDeleteSet, forest);

        // if current node needs to be deleted
        if (toDeleteSet.contains(node.val)) {
            // if the node has left or right children, we need to add them to forest
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return null;
        }
        return node;
    }
}
