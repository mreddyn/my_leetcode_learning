package com.company.microsoft.leetcode.easy;

import java.util.ArrayDeque;

import com.leetcode_daily_challenge.TreeNode;

public class CousinsInABinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        /*
         * We will do a level order traversal to search the nodes (x and y) to see if
         * they
         * are at same level or not.
         * We will maintain a queue for this traversal (also storing its parent)
         */
        if (root.val == x || root.val == y) {
            return false;
        }
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, -1));
        int depth = 0, xDepthAndParent[] = new int[2], yDepthAndParent[] = new int[2];
        boolean foundX = false, foundY = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair curPair = queue.poll();
                TreeNode node = curPair.node;
                if (!foundX && node.val == x) {
                    foundX = true;
                    xDepthAndParent[0] = depth;
                    xDepthAndParent[1] = curPair.parentNodeVal;
                }
                if (!foundY && node.val == y) {
                    foundY = true;
                    yDepthAndParent[0] = depth;
                    yDepthAndParent[1] = curPair.parentNodeVal;
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
