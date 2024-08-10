package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    private List<TreeNode> inOrderList;

    public TreeNode balanceBST(TreeNode root) {
        /*
         * To balance a binary search tree, we need to create a list after traversing
         * the tree
         * using in-order traversal.
         * Now mid element as root node, elements to the left of root node are left
         * subtree
         * and elements to the right of root node are right subtree
         */
        inOrderList = new ArrayList<>();
        inOrder(root);
        int inOrderListSize = inOrderList.size();

        return sortedListToBST(0, inOrderListSize - 1);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        inOrderList.add(root);
        inOrder(root.right);
    }

    private TreeNode sortedListToBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = inOrderList.get(mid);
        root.left = sortedListToBST(left, mid - 1);
        root.right = sortedListToBST(mid + 1, right);
        return root;
    }
}
