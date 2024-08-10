package com.leetcode_daily_challenge;

import java.util.HashMap;
import java.util.HashSet;

public class CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        /*
         * First insert parent and child into HashMap<Integer, int[2]>
         * TO find the root node we need to insert the children into the HashSet
         * (childrenSet)
         * After iterating the descriptions, to find out the root node.
         * we will iterate through the keys of adjacencyList (which is visiting all
         * parents)
         * so we check these parents in childrenSet, if any of the parents does not
         * exist in
         * childrenSet then we found out our rootNode.
         * Finally Build the BinaryTree from root.
         */
        HashMap<Integer, int[]> adjacencyList = new HashMap<>();
        HashSet<Integer> childrenSet = new HashSet<>();
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            // 1 indicates left, and 0 indicates right child
            boolean isLeft = description[2] == 1;
            adjacencyList.putIfAbsent(parent, new int[] { -1, -1 });
            childrenSet.add(child);
            if (isLeft) {
                adjacencyList.get(parent)[0] = child;
            } else {
                adjacencyList.get(parent)[1] = child;
            }
        }

        // find the root node
        int rootNode = -1;
        for (int parent : adjacencyList.keySet()) {
            if (!childrenSet.contains(parent)) {
                rootNode = parent;
                break;
            }
        }

        // build the Binary Tree from rootNode as root
        TreeNode root = constructBinaryTree(rootNode, adjacencyList);

        return root;
    }

    private TreeNode constructBinaryTree(int nodeVal, HashMap<Integer, int[]> adjacencyList) {
        TreeNode node = new TreeNode(nodeVal);
        if (adjacencyList.containsKey(nodeVal)) {
            int[] children = adjacencyList.get(nodeVal);
            if (children[0] != -1) {
                node.left = constructBinaryTree(children[0], adjacencyList);
            }
            if (children[1] != -1) {
                node.right = constructBinaryTree(children[1], adjacencyList);
            }

        }
        return node;
    }
}
