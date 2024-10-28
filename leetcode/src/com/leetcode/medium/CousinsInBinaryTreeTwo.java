package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import com.leetcode_daily_challenge.TreeNode;

public class CousinsInBinaryTreeTwo {
    public TreeNode replaceValueInTree(TreeNode root) {
        /*
         * First calculate the sum for each level and store it in a ArrayList.
         * Now Do a BFS again, and replace each node value with
         * levelSum-node.val-sibling node.val
         */

        var levelSumList = calculateLevelSumInBinaryTree(root);
        var queue = new ArrayDeque<TreeNode>();
        int level = 1;
        // update the root node value
        root.val = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                int siblingSum = ((node.right != null) ? node.right.val : 0)
                        + ((node.left != null) ? node.left.val : 0);

                if (node.left != null) {
                    node.left.val = levelSumList.get(level) - siblingSum;
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    node.right.val = levelSumList.get(level) - siblingSum;
                    queue.offer(node.right);
                }
            }
            level++;
        }

        return root;
    }

    private List<Integer> calculateLevelSumInBinaryTree(TreeNode root) {
        var queue = new ArrayDeque<TreeNode>();
        var levelSumList = new ArrayList<Integer>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelSumList.add(levelSum);
        }

        return levelSumList;
    }
}
