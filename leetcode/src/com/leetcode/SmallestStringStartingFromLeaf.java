package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode_daily_challenge.TreeNode;

public class SmallestStringStartingFromLeaf {

    private String smallestLeaf(TreeNode root) {
        String smallestString = "";
        Queue<CustomPair> queue = new LinkedList<>();
        queue.add(new CustomPair(root, (char) (root.val + 'a') + ""));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                CustomPair pair = queue.poll();
                TreeNode node = pair.node;
                String currentString = pair.str;
                // if leaf node
                if (node.left == null && node.right == null) {
                    if (smallestString.isEmpty()) {
                        smallestString = currentString;
                    } else {
                        smallestString = currentString.compareTo(smallestString) < 0 ? currentString : smallestString;
                    }
                }

                if (node.left != null) {
                    queue.add(new CustomPair(node.left, (char) (node.left.val + 'a') + currentString));
                }
                if (node.right != null) {
                    queue.add(new CustomPair(node.right, (char) (node.right.val + 'a') + currentString));
                }
            }
        }

        return smallestString;
    }

    class CustomPair {
        TreeNode node;
        String str;

        CustomPair(TreeNode node, String str) {
            this.node = node;
            this.str = str;
        }
    }
    public static void main(String[] args) {
        SmallestStringStartingFromLeaf smallestStringStartingFromLeaf = new SmallestStringStartingFromLeaf();
        smallestStringStartingFromLeaf.smallestLeaf(null);
    }
}
