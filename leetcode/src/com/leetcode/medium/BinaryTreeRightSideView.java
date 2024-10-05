package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import com.leetcode_daily_challenge.TreeNode;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        var rightSideViewedNodesList = new ArrayList<Integer>();
        if (root == null) {
            return rightSideViewedNodesList;
        }

        // queue for the level order traversal
        var queue = new ArrayDeque<TreeNode>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            rightSideViewedNodesList.add(queue.peekFirst().val);
            while (size-- > 0) {
                TreeNode node = queue.poll();
                // add the right child first to queue
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }

        return rightSideViewedNodesList;
    }

    public List<Integer> rightSideViewRecursiveApproach(TreeNode root) {
        var rightSideViewedNodesList = new ArrayList<Integer>();
        if (root == null) {
            return rightSideViewedNodesList;
        }
        rightView(root, rightSideViewedNodesList, 0);
        return rightSideViewedNodesList;
    }

    private void rightView(TreeNode node, ArrayList<Integer> rightSideViewedNodesList, int depth) {
        if (node == null) {
            return;
        }

        // when the depth is equal to list size, we add the node val
        if (depth == rightSideViewedNodesList.size()) {
            rightSideViewedNodesList.add(node.val);
        }

        // traverse right subtree and left subtree
        rightView(node.right, rightSideViewedNodesList, depth + 1);
        rightView(node.left, rightSideViewedNodesList, depth + 1);
    }
}
