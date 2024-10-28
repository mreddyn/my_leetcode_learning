package com.leetcode.easy;

import java.util.ArrayDeque;

import com.leetcode_daily_challenge.TreeNode;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        // Queue for BFS traversal
        var queue = new ArrayDeque<Pair>();
        var depth = 0;
        var xDepthAndParent = new int[2];
        var yDepthAndParent = new int[2];
        boolean foundX = false, foundY = false;

        queue.offer(new Pair(root, -1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair curPair = queue.poll();
                TreeNode node = curPair.node;
                int parentNodeVal = curPair.parentNodeVal;

                if (!foundX && node.val == x) {
                    xDepthAndParent[0] = depth;
                    xDepthAndParent[1] = parentNodeVal;
                }

                if (!foundY && node.val == y) {
                    yDepthAndParent[0] = depth;
                    yDepthAndParent[1] = parentNodeVal;
                }

                if (node.left != null) {
                    queue.offer(new Pair(node.left, node.val));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, node.val));
                }
            }
            depth++;
            if (foundX && foundY) {
                break;
            }
        }
        return xDepthAndParent[0] == yDepthAndParent[0] && xDepthAndParent[1] != yDepthAndParent[1];
    }

    class Pair {
        TreeNode node;
        int parentNodeVal;

        Pair(TreeNode node, int parentNodeVal) {
            this.node = node;
            this.parentNodeVal = parentNodeVal;
        }
    }
}
