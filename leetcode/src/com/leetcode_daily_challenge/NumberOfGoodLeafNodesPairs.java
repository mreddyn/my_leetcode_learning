package com.leetcode_daily_challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class NumberOfGoodLeafNodesPairs {
    HashSet<TreeNode> leafNodesList;
    Map<TreeNode, List<TreeNode>> graph;

    public int countPairs(TreeNode root, int distance) {
        /*
         * Build the tree into a graph of adjacencyList (u->v, v->u)
         * While building if a leaf node is encountered then add it to a set
         * For each leaf node in the set, visit the neighbors for distance using BFS
         */
        int goodLeafPairsCount = 0;
        leafNodesList = new HashSet<>();
        graph = new HashMap<>();
        // build the graph from BinaryTree
        traverseTree(root, null);

        for (TreeNode leaf : leafNodesList) {
            ArrayDeque<TreeNode> bfsQueue = new ArrayDeque<>();
            HashSet<TreeNode> visited = new HashSet<>();
            bfsQueue.offer(leaf);
            visited.add(leaf);
            for (int i = 0; i <= distance; i++) {
                int size = bfsQueue.size();
                for (int j = 0; j < size; j++) {
                    TreeNode curNode = bfsQueue.poll();
                    if (leafNodesList.contains(curNode) && curNode != leaf) {
                        goodLeafPairsCount++;
                    }
                    if (graph.containsKey(curNode)) {
                        for (TreeNode neighbor : graph.get(curNode)) {
                            if (!visited.contains(neighbor)) {
                                bfsQueue.offer(neighbor);
                                visited.add(neighbor);
                            }
                        }
                    }
                }
            }
        }

        return goodLeafPairsCount;
    }

    private void traverseTree(TreeNode curNode, TreeNode prevNode) {
        if (curNode == null) {
            return;
        }
        if (curNode.left == null && curNode.right == null) {
            leafNodesList.add(curNode);
        }
        if (prevNode != null) {
            graph.putIfAbsent(prevNode, new ArrayList<>());
            graph.putIfAbsent(curNode, new ArrayList<>());
            graph.get(prevNode).add(curNode);
            graph.get(curNode).add(prevNode);
        }
        traverseTree(curNode.left, curNode);
        traverseTree(curNode.right, curNode);
    }

}
